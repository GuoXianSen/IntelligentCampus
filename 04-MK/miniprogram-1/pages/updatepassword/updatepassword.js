// pages/updatepassword/updatepassword.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  handleInputChange_password: function(e){
    this.setData({
      password:e.detail.value
    })
   },
  handleInputChange_confpassword: function(e){
    this.setData({
      confpassword:e.detail.value
    })
   },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var id1=options.id;
    console.log(id1);
    this.setData({
      id:id1
    })
  },
  register:function(options){
    var that=this;
   if(that.data.password!=that.data.confpassword){
      wx.showModal({
      title: '提示',      
      content: '两次密码输入不一致，请重新输入',      
      success: function(res) {     
      if (res.confirm) {     
      console.log('用户点击确定')      
      } else if (res.cancel) {     
      console.log('用户点击取消')     
      }      
      }     
      })    
      
   }else
   
    
    wx.request({      
      url: "http://192.168.31.48:8080/web/UserServlet", 
      method:"Get",
      data: { 
        id:that.data.id,
        // password:that.data.password,
        method:"psdUpdatewx",    
        // username:this.data.account,
        password:that.data.password,    
      //  phonenumber: that.data.phone,
        // confpassword:handleInputChange_confpassword,
        // age:that.data.age,
        // email:that.data.email,
        // sex:that.data.sex[that.data.xb].value,
        // college:that.data.selectData[that.data.index],
        // major:that.data.major
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res)
        // that.setData(
        //   {
        //     userinfo:res.data,         
        //  })    
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