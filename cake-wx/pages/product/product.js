// pages/product/product.js
var config = require('../../config')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    comments: [],
    product: {},
    sizeItem: {},
    count: 1,
    selectedId: 0,
    shopcartCount: 0,
    showShade: false,    //显示遮罩层
    bodyheight: 0,
    windowWidth: 0
  },
  onTitleTap: function (e) {
    var id = e.currentTarget.id;
    this.setData({ selectedId: id });
  },
  onCurrentChange: function (e) {
    this.setData({ selectedId: e.detail.current });
  },
  onChooseSizeTap: function () {
    this.onAddTap()
  },
  onAddTap: function () {
    this.translate_animation.translateY(-this.data.windowWidth / 750 * 1200).step()
    this.shade_animation.opacity(0.3).step()
    this.setData({
      showShade: true,
      translate_animation: this.translate_animation.export(),
      shade_animation: this.shade_animation.export()
    })
  },
  onCloseTap: function () {
    this.onBlankTap()
  },
  onBlankTap: function () {
    this.translate_animation.translateY(0).step();
    this.shade_animation.opacity(-0.3).step()
    var that = this
    setTimeout(function () {
      that.setData({ showShade: false })
    }, 500)
    this.setData({
      translate_animation: this.translate_animation.export(),
      shade_animation: this.shade_animation.export()
    })
  },
  onConfirmTap: function () {
    this.translate_animation.translateY(0).step();
    this.shade_animation.opacity(-0.3).step()
    setTimeout(function () {
      that.setData({ showShade: false })
    }, 500)
    var that = this, productId = this.data.product.productId,
      sizeId = this.data.sizeItem.sizeId, count = this.data.count
    config.request({
      url: config.addToShopcartUrl + productId + "/" + sizeId + "/" + count,
      method: 'PUT',
      success: function (res) {
        that.setData({ shopcartCount: res })
        wx.showToast({
          title: '加入购物车成功',
        })
      }
    })
    this.setData({
      translate_animation: this.translate_animation.export(),
      shade_animation: this.shade_animation.export()
    })
  },
  onShopcartTap: function () {
    console.log("navigate to")
    wx.switchTab({
      url: '/pages/shopcart/shopcart',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var id = options.id, that = this
    //获取屏幕高度
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          bodyHeight: res.windowHeight - res.windowWidth / 750 * 140,
          windowWidth: res.windowWidth
        });
      },
    })
    //请求商品信息
    config.request({
      url: config.getProductUrl + id,
      success: function (res) {
        that.setData({
          product: res,
          sizeItem: res.sizeList[0]
        })
        wx.setNavigationBarTitle({
          title: res.title,
        })
      }
    })
    //请求评价数据
    config.request({
      url: config.getCommentsUrl + id,
      success: function (res) {
        that.setData({ comments: res })
      }
    })
    //请求购物车数量
    config.request({
      url: config.countShopcartUrl,
      success: function (res) {
        that.setData({ shopcartCount: res })
      }
    })
  },
  onSizeTap: function (e) {
    var sizeItem = e.target.dataset.item;
    this.setData({
      sizeItem: sizeItem
    })
  },
  onCountSub: function () {
    var count = this.data.count
    this.setData({ count: count > 1 ? count - 1 : count })
  },
  onCountAdd: function () {
    var count = this.data.count
    this.setData({ count: count + 1 })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.translate_animation = wx.createAnimation({
      duration: 500,
      timingFunction: "ease",
      delay: 0
    })
    this.shade_animation = wx.createAnimation({
      duration: 500,
      timingFunction: "linear",
      delay: 0
    })
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