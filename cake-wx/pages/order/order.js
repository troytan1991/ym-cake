// pages/order/order.js
var config = require('../../config')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    products: [],
    price: "0.00",
    totalPrice: "0.00",
    freight: "0.00",
    payMethod: 1,
    deliverMethod: 0,
    deliverTime: [
      { "rangeKey": "10:00-11:00" },
      { "rangeKey": "11:00-12:00" },
      { "rangeKey": "12:00-13:00" },
      { "rangeKey": "13:00-14:00" },
      { "rangeKey": "14:00-15:00" },
      { "rangeKey": "15:00-16:00" },
      { "rangeKey": "16:00-17:00" },
      { "rangeKey": "17:00-18:00" },
      { "rangeKey": "18:00-19:00" },
      { "rangeKey": "19:00-20:00" }
    ],
    dataArray: [],
    index: [0, 0]
  },
  onRemarkInput: function (e) {
    this.setData({ remark: e.detail.value })
  },

  onCommitTap: function () {
    var productList = [], products = this.data.products,
      dataArray = this.data.dataArray, index = this.data.index

    for (var i in products) {
      var product = products[i]
      productList.push({
        "productId": product.productId,
        "sizeId": product.sizeId,
        "count": product.count
      })
    }
    var orderData = {
      "productList": productList,
      "addrId": this.data.addr.addrId,
      "payMethod": this.data.payMethod,
      "deliverMethod": this.data.deliverMethod,
      "remark": this.data.remark,
      "deliverDate": dataArray[0][index[0]].date,
      "deliverTime": dataArray[1][index[1]].rangeKey
    }
    console.log(orderData)
    config.request({
      url: config.createOrderUrl,
      method: 'PUT',
      data: orderData,
      success: function (res) {
        console.log(res)
        wx.showModal({
          title: '订单提交成功',
          showCancel: false,
          success: function () {
            wx.navigateBack({})
          }
        })
      }
    })


  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    //获取已选商品
    wx.getStorage({
      key: 'selectedProducts',
      success: function (res) {
        that.setData({ products: res.data });
        that.refreshPrice();
      },
    })
    //获取默认地址
    config.request({
      url: config.getDefaultAddrUrl,
      success: function (res) {
        that.setData({ addr: res })
      }
    })
    //初始化配送方式数据
    var dataArray = this.data.dataArray
    dataArray[0] = this.getDates(7)
    dataArray[1] = this.data.deliverTime
    this.setData({ dataArray: dataArray })
  },
  onOnlineTap: function (e) {
    wx.showToast({
      title: '暂不支持在线支付',
      icon: 'none'
    })
  },
  onCashTap: function (e) {
    this.setData({ payMethod: 1 })
  },
  onDeliverTap: function (e) {
    this.setData({ deliverMethod: 0 })
  },
  onPickTap: function (e) {
    this.setData({ deliverMethod: 1 })
    console.log(this.getDates(7))
  },
  onPickerChange: function (e) {
    this.setData({ index: e.detail.value })
  },
  getDates: function (days, todate = new Date()) {//todate默认参数是当前日期，可以传入对应时间
    var dateArry = [];
    for (var i = 1; i <= days; i++) {
      var dateObj = this.dateLater(todate, i);
      dateArry.push(dateObj)
    }
    return dateArry;
  },
  dateLater: function (dates, later) {
    let dateObj = {};
    let show_day = new Array('周日', '周一', '周二', '周三', '周四', '周五', '周六');
    let date = new Date(dates);
    date.setDate(date.getDate() + later)
    dateObj.date = date.getTime()
    dateObj.rangeKey = date.getMonth() + 1 + "月" + date.getDate() + "日" + " " + show_day[date.getDay()]
    // dateObj.week = show_day[date.getDay()];
    return dateObj;
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    console.log("onReady")
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log("onShow")
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    console.log("onHide")
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    console.log("onUnload")
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  /**
   * 刷新价格表信息
   */
  refreshPrice: function () {
    var products = this.data.products, price = 0, totalPrice = 0;
    console.log("--" + products)
    var freight = this.getFreight(products);
    for (var index in products) {
      price += products[index].price * products[index].count;
    }
    totalPrice = price + freight;
    this.setData({
      price: price.toFixed(2),
      freight: freight.toFixed(2),
      totalPrice: totalPrice.toFixed(2)
    })
  },
  /**
   * 计算运费信息
   */
  getFreight: function (products) {
    return 0;
  }
})