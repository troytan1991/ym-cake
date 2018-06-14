// pages/ship/ship.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    payMethod: 1,
    deliverMethod: 0,
    time: [
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
  onConfirmTap: function (e) {
    var data = {}, dataArray = this.data.dataArray, index = this.data.index
    data.payMethod = this.data.payMethod
    data.deliverMethod = this.data.deliverMethod
    data.date = dataArray[0][index[0]].date
    data.time = dataArray[1][index[1]].rangeKey
    console.log(data)
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
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var dataArray = this.data.dataArray
    dataArray[0] = this.getDates(7)
    dataArray[1] = this.data.time
    this.setData({ dataArray: dataArray })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

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

  }
})