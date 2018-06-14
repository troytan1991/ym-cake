var config = require('../../config.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areas: [[], [], []],
    indexArray: [0, 0, 0],
    addr: {}
  },

  onColumnChange: function (e) {
    var change = e.detail, areas = this.data.areas,
      that = this, indexArray = this.data.indexArray, addr = this.data.addr
    wx.getStorage({
      key: 'areas',
      success: function (res) {
        switch (change.column) {
          case 0:
            indexArray[1] = indexArray[2] = 0
            var city = res.data[change.value].childs
            if (typeof city == "undefined" || city.length == 0) {
              areas[1] = areas[2] = []
            } else {
              areas[1] = city
              if (typeof city[0].childs == "undefined") {
                areas[2] = []
              } else {
                areas[2] = city[0].childs
              }
            }
            break;
          case 1:
            indexArray[2] = 0
            var district = res.data[indexArray[0]].childs[change.value].childs
            areas[2] = typeof (district) == "undefined" ? [] : district
            break;
        }
        indexArray[change.column] = change.value
        console.log(addr)
        that.setData({
          indexArray: indexArray,
          areas: areas
        })
      },
    })

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    if (typeof (options.addr) == "undefined") {
      //新增地址
      wx.setNavigationBarTitle({
        title: "新增地址",
      })
    } else {
      //编辑地址
      var addr = JSON.parse(options.addr)
      console.log(addr)
      this.setData({ addr: addr, indexArray: addr.indexArray.split(",") })
      wx.setNavigationBarTitle({
        title: "编辑地址",
      })
    }

    wx.getStorage({
      key: 'areas',
      success: function (res) {
        console.log(res)
        that.refreshAreaData(res.data)
      },
      fail: function () {
        wx.request({
          url: config.getAreasUrl,
          success: res => {
            wx.setStorageSync("areas", res.data)
            that.refreshAreaData(res.data)
          }
        })
      }
    })
  },
  refreshAreaData: function (data) {
    var areas = [[], [], []], indexArray = this.data.indexArray
    for (var i in data) {
      areas[0].push({ name: data[i].name })
    }
    areas[1] = data[indexArray[0]].childs
    areas[2] = data[indexArray[0]].childs[indexArray[1]].childs
    this.setData({ areas: areas })

  },
  onSaveTap: function () {
    var addr = this.data.addr, areas = this.data.areas, indexArray = this.data.indexArray
    if (typeof (addr.receiver) == "undefined" || addr.receiver == "") {
      wx.showToast({
        title: '收货人信息不能为空!',
        icon: 'none'
      })
      return
    }
    if (typeof (addr.phone) == "undefined" || addr.phone == "") {
      wx.showToast({
        title: '联系方式不能为空!',
        icon: 'none'
      })
      return
    }
    if (typeof (addr.detail) == "undefined" || addr.detail == "") {
      wx.showToast({
        title: '详细地址不能为空!',
        icon: 'none'
      })
      return
    }
    if (typeof addr.isDefault == "undefined") {
      addr.isDefault = false
    }
    addr.indexArray = indexArray.join(",")
    addr.areaId = areas[2][indexArray[2]].id
    if (typeof (addr.addrId) == "undefined") {
      //新增接口
      config.request({
        url: config.putAddrUrl,
        method: "PUT",
        data: addr,
        success: function (res) {
          wx.navigateBack({
          })
        }
      })
    } else {
      //更新接口
      config.request({
        url: config.postAddrUrl,
        method: "POST",
        data: addr,
        success: function (res) {
          wx.navigateBack({
          })
        }
      })
    }
    console.log(addr)
  },
  onReceiverInput: function (e) {
    var addr = this.data.addr
    addr.receiver = e.detail.value
    this.setData({ addr: addr })
  },
  onContactInput: function (e) {
    var addr = this.data.addr
    addr.phone = e.detail.value
    this.setData({ addr: addr })
  },
  onDetailInput: function (e) {
    var addr = this.data.addr
    addr.detail = e.detail.value
    this.setData({ addr: addr })
  },
  onSwitchChange: function (e) {
    console.log(e.detail.value)
    var addr = this.data.addr
    addr.isDefault = e.detail.value
    this.setData({ addr: addr })
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