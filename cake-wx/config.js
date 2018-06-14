var host = "https://troytan1991.club"
var rootPath = "https://troytan1991.club/ymcake/rest"
// var rootPath = "https://www.mcake.com/ymcake/rest"
var config = {
  host,
  loginUrl: `${rootPath}/user/login`,

  //product urls
  getProductUrl: `${rootPath}/product/`,
  getProductsUrl: `${rootPath}/product/products`,

  //order urls
  createOrderUrl: `${rootPath}/order/create`,
  getOrdersUrl: `${rootPath}/order/`,
  countOrderUrl: `${rootPath}/order/count`,
  cancelOrderUrl: `${rootPath}/order/cancel/`,
  payOrderUrl: `${rootPath}/order/pay/`,
  remindOrderUrl: `${rootPath}/order/remind/`,
  getDeliveryUrl: `${rootPath}/order/delivery/`,
  receiveOrderUrl: `${rootPath}/order/receive/`,
  commentOrderUrl: `${rootPath}/order/comment`,
  deleteOrderUrl: `${rootPath}/order/`,

  //comment urls
  getCommentsUrl: `${rootPath}/comment/`,
  createCommentUrl: `${rootPath}/comment/`,

  //shopcart Urls
  getShopcartsUrl: `${rootPath}/shopcart/shopcarts`,
  addToShopcartUrl: `${rootPath}/shopcart/`,
  increaseShopcartUrl: `${rootPath}/shopcart/increase/`,
  decreaseShopcartUrl: `${rootPath}/shopcart/decrease/`,
  countShopcartUrl: `${rootPath}/shopcart/count`,
  deleteShopcartUrl: `${rootPath}/shopcart/`,

  //addr Urls
  getAddrsUrl: `${rootPath}/addr/addrs`,
  putAddrUrl: `${rootPath}/addr`,
  postAddrUrl: `${rootPath}/addr`,
  setAddrDefaultUrl: `${rootPath}/addr/setDefault/`,
  deleteAddrUrl: `${rootPath}/addr/`,
  getDefaultAddrUrl: `${rootPath}/addr/getDefault`,
  getAreasUrl: `${rootPath}/addr/areas`,

  /**
   * 统一请求的封装
   */
  request: function ({ url, method = 'GET', data = {}, success }) {
    wx.getStorage({
      key: 'sessionId',
      success: function (res) {
        wx.request({
          url: url + "?sessionId=" + res.data,
          method: method,
          data: data,
          success: function (res) {
            var msg = ''
            if (res.statusCode < 400) {
              success(res.data)
              return
            } else if (res.statusCode == 401) {
              if (getApp().globalData.userInfo) {
                delete getApp().globalData.userInfo
                wx.removeStorageSync("sessionId")
              }
              msg = '用户授权过期，请重新登录!'
            } else if (res.statusCode == 500) {
              msg = '服务器内部错误!'
            } else {
              msg = '错误的请求'
            }
            wx.showToast({
              title: msg,
              icon: 'none'
            })
          },
          fail: function () {
            wx.showToast({
              title: '请求失败',
            })
          }
        })
      },
    })

  }
};

module.exports = config