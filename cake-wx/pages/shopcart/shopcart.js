// pages/shopcart/shopcart.js
var config = require('../../config')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    carts: [],
    isSelectAll: false,
    totalPrice: "0.00",
    scrollY: true
  },
  swipeCheckX: 35, //激活检测滑动的阈值
  swipeCheckState: 0, //0未激活 1激活
  maxMoveLeft: 75, //消息列表项最大左滑距离
  correctMoveLeft: 75, //显示菜单时的左滑距离
  thresholdMoveLeft: 37,//左滑阈值，超过则显示菜单
  lastShowMsgId: '', //记录上次显示菜单的消息id
  moveX: 0,  //记录平移距离
  showState: 0, //0 未显示菜单 1显示菜单
  touchStartState: 0, // 开始触摸时的状态 0 未显示菜单 1 显示菜单
  swipeDirection: 0, //是否触发水平滑动 0:未触发 1:触发水平滑动 2:触发垂直滑动

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        //scrollView设置高度后才能禁用垂直滑动生效
        that.setData({
          scrollViewHeight: res.windowHeight - res.windowWidth / 750 * 45
        });
      },
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.getTotalPrice();
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this
    config.request({
      url: config.getShopcartsUrl,
      success: function (res) {
        that.setData({
          carts: res,
          isSelectAll: false
        })
        that.getTotalPrice()
      }
    })
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
    console.log("shopcart页面刷新");
    wx.stopPullDownRefresh();
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
  onImgTab: function (e) {
    var productId = e.target.dataset.id
    wx.navigateTo({
      url: '/pages/product/product?id=' + productId
    })
  },
  /**
   * 选中与否监听
   */
  onCheckChanged: function (e) {
    var carts = this.data.carts, index = this.getItemIndex(e.target.dataset.id)
    carts[index].isSelected = !carts[index].isSelected;
    this.setData({
      carts: carts
    });
    this.getTotalPrice();
  },
  /**
   * 全选勾选监听
   */
  selectAll: function () {
    var isSelectAll = !this.data.isSelectAll,
      carts = this.data.carts;
    for (var i = 0; i < carts.length; i++) {
      carts[i].isSelected = isSelectAll;
    }
    this.getTotalPrice();
    this.setData({
      carts: carts,
      isSelectAll: isSelectAll
    });
  },
  /**
   * 增加数量
   */
  onSubstract: function (e) {
    var index = this.getItemIndex(e.target.dataset.id),
      carts = this.data.carts, cart = carts[index], that = this
    if (cart.count > 1) {
      config.request({
        url: config.decreaseShopcartUrl + cart.productId + "/" + cart.sizeId,
        method: 'POST',
        success: function () {
          carts[index].count--;
          that.setData({ carts: carts });
          that.getTotalPrice();
        }
      })
    }
  },
  /**
   * 减少数量
   */
  onAdd: function (e) {
    var index = this.getItemIndex(e.target.dataset.id),
      carts = this.data.carts, cart = carts[index], that = this
    //更新服务器
    config.request({
      url: config.increaseShopcartUrl + cart.productId + "/" + cart.sizeId,
      method: 'POST',
      success: function () {
        carts[index].count++;
        that.setData({ carts: carts });
        that.getTotalPrice();
      }
    })
  },
  /**
   * 刷新总价格
   */
  getTotalPrice: function () {
    var carts = this.data.carts, totalPrice = 0;
    for (var i = 0; i < carts.length; i++) {
      if (carts[i].isSelected) {
        totalPrice += carts[i].price * carts[i].count;
      }
    }
    this.setData({
      totalPrice: totalPrice.toFixed(2)
    });
  },
  /**
   * 结算跳转
   */
  onPayBtnTap: function () {
    var carts = this.data.carts, selectedCarts = [];
    for (var i = 0; i < carts.length; i++) {
      if (carts[i].isSelected) {
        selectedCarts.push(carts[i])
      }
    }
    if (selectedCarts.length <= 0) {
      wx.showToast({
        title: '未选择任何商品!',
        icon: 'none'
      })
    } else {
      wx.setStorage({
        key: 'selectedProducts',
        data: selectedCarts,
      })
      wx.navigateTo({
        url: '/pages/order/order',
      })
    }
  },
  /********滑动删除逻辑*********/
  onTouchStart: function (e) {
    if (this.showState == 1) {
      this.touchStartState = 1;
      this.showState = 0;
      this.moveX = 0;
      this.translateXMsgItem(this.lastShowMsgId, 0, 200);
      this.lastShowMsgId = "";
      return;
    }
    this.firstTouchX = e.touches[0].clientX;
    this.firstTouchY = e.touches[0].clientY;
    if (this.firstTouchX > this.swipeCheckX) {
      this.swipeCheckState = 1;
    }
    this.lastMoveTime = e.timeStamp;
  },

  onTouchMove: function (e) {
    if (this.swipeCheckState == 0) {
      return;
    }
    //当开始触摸时有菜单显示时，不处理滑动操作
    if (this.touchStartState == 1) {
      return;
    }
    var moveX = e.touches[0].clientX - this.firstTouchX;
    var moveY = e.touches[0].clientY - this.firstTouchY;
    //已触发垂直滑动，由scroll-view处理滑动操作
    if (this.swipeDirection == 2) {
      return;
    }
    //未触发滑动方向
    if (this.swipeDirection == 0) {
      //触发垂直操作
      if (Math.abs(moveY) > 4) {
        this.swipeDirection = 2;

        return;
      }
      //触发水平操作
      if (Math.abs(moveX) > 4) {
        this.swipeDirection = 1;
        this.setData({ scrollY: false });
      }
      else {
        return;
      }

    }
    //禁用垂直滚动
    // if (this.data.scrollY) {
    //   this.setData({scrollY:false});
    // }

    this.lastMoveTime = e.timeStamp;
    //处理边界情况
    if (moveX > 0) {
      moveX = 0;
    }
    //检测最大左滑距离
    if (moveX < -this.maxMoveLeft) {
      moveX = -this.maxMoveLeft;
    }
    this.moveX = moveX;
    this.translateXMsgItem(e.currentTarget.id, moveX, 0);
  },
  onTouchEnd: function (e) {
    this.swipeCheckState = 0;
    var swipeDirection = this.swipeDirection;
    this.swipeDirection = 0;
    if (this.touchStartState == 1) {
      this.touchStartState = 0;
      this.setData({ scrollY: true });
      return;
    }
    //垂直滚动，忽略
    if (swipeDirection !== 1) {
      return;
    }
    if (this.moveX == 0) {
      this.showState = 0;
      //不显示菜单状态下,激活垂直滚动
      this.setData({ scrollY: true });
      return;
    }
    if (this.moveX == this.correctMoveLeft) {
      this.showState = 1;
      this.lastShowMsgId = e.currentTarget.id;
      return;
    }
    if (this.moveX < -this.thresholdMoveLeft) {
      this.moveX = -this.correctMoveLeft;
      this.showState = 1;
      this.lastShowMsgId = e.currentTarget.id;
    }
    else {
      this.moveX = 0;
      this.showState = 0;
      //不显示菜单,激活垂直滚动
      this.setData({ scrollY: true });
    }
    this.translateXMsgItem(e.currentTarget.id, this.moveX, 200);
  },
  onDelCart: function (e) {
    this.deleteMsgItem(e);
  },

  getItemIndex: function (id) {
    var carts = this.data.carts
    for (var i = 0; i < carts.length; i++) {
      if (carts[i].shopcartId == id) {
        return i;
      }
    }
    return -1;
  },
  deleteMsgItem: function (e) {
    var animation = wx.createAnimation({ duration: 200 }),
      shopcartId = e.target.dataset.id, that = this
    animation.height(0).opacity(0).step();
    this.animationMsgWrapItem(shopcartId, animation);
    setTimeout(function () {
      config.request({
        url: config.deleteShopcartUrl + shopcartId,
        method: 'DELETE',
        success: function (res) {
          that.setData({ carts: res })
          that.getTotalPrice();
        }
      })
    }, 200);
    this.showState = 0;
    this.setData({ scrollY: true });
  },
  translateXMsgItem: function (id, x, duration) {
    var animation = wx.createAnimation({ duration: duration });
    animation.translateX(x).step();
    this.animationMsgItem(id, animation);
  },
  animationMsgItem: function (id, animation) {
    var index = this.getItemIndex(id);
    var param = {};
    var indexString = 'carts[' + index + '].animation';
    param[indexString] = animation.export();
    this.setData(param);
  },
  animationMsgWrapItem: function (id, animation) {
    var index = this.getItemIndex(id);
    var param = {};
    var indexString = 'carts[' + index + '].wrapAnimation';
    param[indexString] = animation.export();
    this.setData(param);
  }
})