// pages/addr/addr.js
var config = require('../../config')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    addrs: [],
    selectedId: 0,
    scrollHeight: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("onload")
    var that = this
    this.setData({ selectedId: options.selectedId })
    this.refreshData()
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          scrollHeight: res.windowHeight - res.windowWidth / 750 * 110,
        });
      },
    })
  },
  refreshData: function () {
    var that = this
    config.request({
      url: config.getAddrsUrl,
      success: function (res) {
        that.setData({ addrs: res })
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
    this.refreshData()
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

  },
  /**
   * 地址点击函数
   */
  onAddrTap: function (e) {
    var addr = e.currentTarget.dataset.item
    console.log(e)
    this.setData({ selectedId: addr.addrId })
    var prevPage = getCurrentPages()[getCurrentPages().length - 2]
    prevPage.setData({ addr: addr })
    wx.navigateBack({})

  },
  onEditTap: function (e) {
    var addr = e.currentTarget.dataset.addr
    console.log(addr)
    wx.navigateTo({
      url: '/pages/editaddr/editaddr?addr=' + JSON.stringify(addr),
    })
  },
  onAddTap: function (e) {
    wx.navigateTo({
      url: '/pages/editaddr/editaddr',
    })
  }
})