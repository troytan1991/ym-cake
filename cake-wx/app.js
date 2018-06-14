//app.js
App({

  data: {
  },
  onLaunch: function () {
    wx.getSetting({
      success: res => {
        if (!res.authSetting['scope.userInfo']) {
          wx.showModal({
            title: '用户未授权',
            content: "请到'我的'页面，点击获取用户头像",
          })
        }
      }
    }),
    wx.login({
      success: res=>{
       console.log(res.code)
      }
    })
    // wx.login({
    //   success: res => {
    //     console.log(res.code)
    //   }
    // }),
    //   wx.getUserInfo({
    //     success: res => {
    //       var userInfo = res.userInfo
    //       wx.login({
    //         success: res => {
    //           console.log("code:" + res.code)
    //           console.log(userInfo)
    //         }
    //       })
    //     }
    //   })
    // // 登录
    // wx.login({
    //   success: res => {
    //     // 发送 res.code 到后台换取 openId, sessionKey, unionId
    //     console.log(res.code)
    //   }
    // })
    // // 获取用户信息
    // wx.getSetting({
    //   success: res => {
    //     if (res.authSetting['scope.userInfo']) {
    //       // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
    //       wx.getUserInfo({
    //         success: res => {
    //           // 可以将 res 发送给后台解码出 unionId
    //           this.globalData.userInfo = res.userInfo
    //           console.log(res.userInfo)
    //           // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
    //           // 所以此处加入 callback 以防止这种情况
    //           if (this.userInfoReadyCallback) {
    //             this.userInfoReadyCallback(res)
    //           }
    //         }
    //       })
    //     }
    //   }
    // })
  },
  globalData: {
    userInfo: null
  }
})