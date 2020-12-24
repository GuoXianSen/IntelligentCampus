// pages/yinliao/yinliao.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    shouji:app.globalData.shouji,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    wx.request({
      url: this.data.shouji+'/GoodsServlet',
      method:"Get",
      data:{
        method:"getAllgoods"
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success:function(res){
        // console.log(res.data);
        var yinliao=[];
        for(var i=0;i<res.data.length;i++){         
          if(res.data[i].goodscode==3){         
            yinliao.push(res.data[i]);
         that.setData({
            yinliao:yinliao
         })
        }
        }
           
      },
    })  
  },
  detail: function(e){
    var id=e.currentTarget.dataset.id;   
    wx.navigateTo({
      url: '/pages/detail/detail?id='+id
     
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