// pages/xy1/1.js
Page({
  data: {
    username: '',
    password: ''
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  tz_register:function(){
    wx.navigateTo({
      url: '../register/register'
    })
  },
  onShow: function () {
    // 生命周期函数--监听页面显示
    wx.hideTabBar({})
  },
  onLoad: function () {
   
  },

 
  // 获取输入账号 
  usernameInput: function (e) {
    this.setData({
      username: e.detail.value
    })
  },
 
  // 获取输入密码 
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },

  // 登录处理
  login: function () {
    var that = this;
      wx.request({
        url: 'http://192.168.31.48:8080/web/UserServlet', // 仅为示例，并非真实的接口地址
        method: 'get',
        data: {
          username: that.data.username,
          password: that.data.password,
          method:"userLogin1"
        },
        success(res) {
          console.log(res.data);
          // var x = "1";
           if(res.data =="1"){
              wx.navigateTo({
                url: '../My/My?username='+that.data.username
              })
           }
           else{
             console.log("跳转失败");
           }
        }
      })
  }
})
