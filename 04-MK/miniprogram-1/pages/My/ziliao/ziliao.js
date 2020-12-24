// pages/My/ziliao/ziliao.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var username=options.username;
    //  var phonenumber=options.phonenumber;
     console.log(username);
    var that=this;
    wx.request({
      
      url: "http://192.168.31.48:8080/web/UserServlet", 
      method:"Get",
      data: { 
        method:"getUserByName",
        username:username,
      //   password:this.data.password,    
      //  phonenumber: this.data.phone,
        // confpassword:handleInputChange_confpassword,
        // age:this.data.age,
        // email:this.data.email,
        // sex:this.data.sex[this.data.xb].value,
        // college:this.data.selectData[this.data.index]
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data),
        that.setData(
           {userinfo:res.data})         
        
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