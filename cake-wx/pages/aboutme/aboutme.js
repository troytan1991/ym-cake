const app = getApp()
var config = require('../../config')
Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    orderCount: {}
  },

  onLoad: function () {
  },
  onCouponTap: function (e) {
    wx.showToast({
      title: '开发中,敬请期待!',
    })
  },
  onFeedbackTap: function (e) {
    wx.showToast({
      title: '开发中,敬请期待!',
    })
  },
  getUserInfo: function (e) {
    var userInfo = e.detail.userInfo
    app.globalData.userInfo = userInfo
    this.setData({
      userInfo: userInfo,
      hasUserInfo: true
    })
    this.login(userInfo)
  },
  //访问后台,登陆系统
  login: function (userInfo) {
    //已存在，则不请求后台
    wx.getStorage({
      key: 'sessionId',
      success: function (res) {
        console.log("请求成功" + res.data)
      },
      fail: function () {
        console.log("请求失败");
        wx.login({
          success: res => {
            userInfo.code = res.code
            wx.request({
              url: config.loginUrl,
              method: 'PUT',
              data: userInfo,
              success: res => {
                if (res.statusCode == 200) {
                  wx.setStorageSync("sessionId", res.data)
                }
              }
            })
          }
        })
      }
    })

  },
  onSettingTap: function () {
    wx.openSetting({
      success: (res) => {
        console.log(res)
      }
    })
  },
  onPullDownRefresh: function () {
    this.onShow()
    wx.stopPullDownRefresh();
  },
  onShow: function () {
    var that = this
    if (app.globalData.userInfo) {
      //数据已缓存
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
      this.login(app.globalData.userInfo)
    } else {
      wx.getSetting({
        success: res => {
          //已授权,请求网络数据
          if (res.authSetting['scope.userInfo']) {
            wx.getUserInfo({
              success: res => {
                app.globalData.userInfo = res.userInfo
                that.setData({
                  userInfo: res.userInfo,
                  hasUserInfo: true
                })
                that.login(res.userInfo)
              }
            })
          }
        }
      })
    }
    this.refreshData()
  },
  onStatusTap: function (e) {
    var status = e.currentTarget.dataset.status
    console.log(e)
    console.log(status)
    wx.navigateTo({
      url: '/pages/orderhistory/orderhistory?status=' + status,
    })
  },
  refreshData: function () {
    var that = this
    //获取订单数量信息
    config.request({
      url: config.countOrderUrl,
      success: function (data) {
        console.log(data)
        that.setData({ orderCount: data })
      }
    })
  }
})
