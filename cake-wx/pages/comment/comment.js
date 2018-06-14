var config = require('../../config')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    comments: [],
    products: [],
    orderId: '',
    remainCount: 500
  },

  onRateChange: function (e) {
    var index = e.target.dataset.id, comments = this.data.comments
    comments[index].rate = e.detail.value
    this.setData({ comments: comments })
  },
  onCommentInput: function (e) {
    var index = e.target.dataset.id, comments = this.data.comments, text = e.detail.value
    comments[index].text = text
    comments[index].remainCount = 500 - text.length
    this.setData({
      comments: comments
    })
  },
  onCancelTap: function (e) {
    wx.navigateBack({})
  },
  onCommitTap: function (e) {
    var comments = this.data.comments, orderId = this.data.orderId, data = []
    for (var i in comments) {
      data.push({
        productId: comments[i].productId,
        rate: comments[i].rate,
        text: comments[i].text
      })
      if (comments[i].text == null || comments[i].text.length == 0) {
        wx.showToast({
          title: '评价不能为空!',
          icon: 'none'
        })
        return
      }
    }
    //更新订单状态，提交评价信息
    console.log(comments)

    config.request({
      url: config.createCommentUrl + orderId,
      method: 'PUT',
      data: data,
      success: function (e) {
        wx.navigateBack({});
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var comments = [], productAll = JSON.parse(options.products), products = []
    var map = new Map()
    //过滤掉相同的productId
    for (var i in productAll) {
      if (!map.has(productAll[i].productId)) {
        map.set(productAll[i].productId, "")
        comments.push({
          productId: productAll[i].productId,
          remainCount: 500,
          rate: 5
        })
        products.push(productAll[i])
      }
    }
    console.log(products)
    this.setData({
      orderId: options.orderId,
      products: products,
      comments: comments
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