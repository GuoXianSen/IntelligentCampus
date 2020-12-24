// pages/cart1/cart1.js
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
      method:"get",
      data:{
        method:"getCollect",
        username:"dly",
      },
      success:function(res){
        console.log(res.data);
        
        that.setData({
          cartinfo:res.data
        })     
      }
    })
  },
  
  //立即购买
  
  buy:function(e){   
    var goodsname=e.currentTarget.dataset.goodsname;
    var that=this;
    wx.request({
      url:app.globalData.shouji+'/GoodsServlet',
      method:"Get",
      data: {
        goodsname:goodsname,
        method:"getGoods"
      },   
      success: function(res){
        console.log(res.data);
        that.setData({
          goodsinfo:res.data,
          goodsstatus:parseInt(res.data.goodsstatus),
          goodsid:res.data.goodsid,
          goodsname:res.data.goodsname,
          goodsimg:res.data.goodsimg,
          goodsprice:res.data.goodsprice,
          goodscode:res.data.goodscode,
          createtime:res.data.createtime,
          updatedtime:res.data.updatedtime,
          goodsnum:res.data.goodsnum

        })
        that.update(e);
      },
     
    })
    
  },
  // 更新购买人数
  update:function(e){
    var that=this;
    // var status= this.data.goodsinfo.goodsstatus,
    // var st=parseInt(that.data.goodsinfo.goodsstatus);
   var st=++that.data.goodsstatus; 
     wx.request({
       url:app.globalData.shouji+'/GoodsServlet',
       method:"Get",
       data: {
         method:"updateGoods",
         goodsid:that.data.goodsid,
         goodsname:that.data.goodsname,
         goodsimg:that.data.goodsimg,
         goodsnum:that.data.goodsnum,
         goodsstatus:st,
         goodsprice:that.data.goodsprice,
         createtime:that.data.createtime,
         updatedtime:that.data.updatedtime,
         goodscode:that.data.goodscode,
         
       },   
       success: function(res){
         console.log(1111);
         that.setData({
           goodsinfo:res.data
         })
       },
      
     })
   },
  
  //删除购物车
  delete:function(e){
    console.log(e)
    var id=e.currentTarget.dataset.goodsid
    
    var that=this;
    wx.request({
      url: this.data.shouji+'/GoodsServlet',
      method:"get",
      data:{
        method:"deleteCollect",
        goodsid:id
      },
      success:function(res){
        console.log(res.data);
        
        if (getCurrentPages().length != 0) {
          //刷新当前页面的数据
          getCurrentPages()[getCurrentPages().length - 1].onLoad()
        }
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
    var that=this;
    wx.request({
      url: this.data.shouji+'/GoodsServlet',
      method:"get",
      data:{
        method:"getCollect",
        username:"dly",
      },
      success:function(res){
        console.log(res.data);
        
        that.setData({
          cartinfo:res.data
        })     
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