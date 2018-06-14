var config = require('../../config')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    selectedId: 1,
    orders: []
  },

  onTitleTap: function (e) {
    var status = e.currentTarget.dataset.status
    this.refreshOrder(status)
  },
  onCancelTap: function (e) {
    var orderId = e.currentTarget.id, that = this
    config.request({
      url: config.cancelOrderUrl + orderId,
      method: 'POST',
      success: function () {
        that.refreshOrder(that.data.selectedId)
      }
    })
  },
  onPayTap: function (e) {
    var orderId = e.currentTarget.id, that = this
    config.request({
      url: config.payOrderUrl + orderId,
      method: 'POST',
      success: function () {
        wx.showToast({
          title: '模拟付款成功',
        })
        that.refreshOrder(that.data.selectedId)
      }
    })
  },
  onRemindTap: function (e) {
    var orderId = e.currentTarget.id, that = this, orders = this.data.orders
    for (var i in orders) {
      if (orders[i].orderId == orderId) {
        orders[i].remind = true
      }
    }
    config.request({
      url: config.remindOrderUrl + orderId,
      method: 'POST',
      success: function () {
        wx.showToast({
          title: '催单成功',
        })
        that.setData({ orders: orders })
      }
    })
  },
  onDeliveryTap: function (e) {
    var deliveryId = e.currentTarget.id, that = this
    wx.showToast({
      title: '物流信息界面待开发',
    })

  },
  onReceiveTap: function (e) {
    var orderId = e.currentTarget.id, that = this
    config.request({
      url: config.receiveOrderUrl + orderId,
      method: 'POST',
      success: function () {
        that.refreshOrder(that.data.selectedId)
      }
    })
  },
  onCommentTap: function (e) {
    var orderId = e.currentTarget.id, products = e.currentTarget.dataset.products, that = this
    console.log(e)
    console.log(products)
    wx.navigateTo({
      url: '/pages/comment/comment?orderId=' + orderId + "&&products=" + JSON.stringify(products),
    })
  },
  onDeleteTap: function (e) {
    var orderId = e.currentTarget.id, that = this
    config.request({
      url: config.deleteOrderUrl + orderId,
      method: 'DELETE',
      success: function () {
        that.refreshOrder(that.data.selectedId)
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.refreshOrder(options.status)
  },
  refreshOrder: function (status) {
    var that = this
    config.request({
      url: config.getOrdersUrl + status,
      success: function (data) {
        console.log(data)
        that.setData({ orders: data, selectedId: status })
      }
    })
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