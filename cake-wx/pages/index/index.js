//index.js
const config = require('../../config')
//获取应用实例
const app = getApp()

Page({
  data: {
    imgUrls: [
      '/images/product/main1.jpg',
      '/images/product/main2.jpg',
      '/images/product/main3.jpg'
    ],
    products: [],
    refreshCount: 0,
    isAddItem: true
  },
  onPullDownRefresh: function () {
    this.refreshProduct()
    wx.stopPullDownRefresh();
  },
  onProductTap: function (e) {
    var productId = e.currentTarget.id;
    wx.navigateTo({
      url: '/pages/product/product?id=' + productId,
    })
  },
  onLoad: function () {
    this.refreshProduct()
  },
  onShow: function () {

  },
  refreshProduct: function () {
    var that = this
    wx.request({
      url: config.getProductsUrl,
      success: function (res) {
        that.setData({
          products: res.data
        })
      }
    })
  }
})
