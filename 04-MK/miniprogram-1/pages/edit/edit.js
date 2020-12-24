// pages/register/register.js
// var index;
var xb;
Page({
  data: {
    sex: [{
      id: 1,
      value: '男'
    }, {
      id: 2,
      value: '女'
    }],
selectData:['计算机信息工程学院','光电学院','外国语学院','经管学院','土木工程学院','化工学院'],//下拉列表的数据
index:0,//选择的下拉列表下标
show:false,//控制下拉列表的显示隐藏，false隐藏、true显示
  },
  optionTap2(e){
    let Index=e.currentTarget.dataset.index;//获取点击的下拉列表的下标
    this.setData({
     xb:Index,
     show:!this.data.show,
    //  index:e.detail.value
    });
    },
radioChange: function (e) {
  // console.log('radio发生change事件，携带value值为：', e.detail.value)
  const sex = this.data.sex
  for (let i = 0, len = sex.length; i < len; ++i) {
    sex[i].checked = sex[i].id == e.detail.value
  }
  this.setData({
    sex:sex
  })
},
selectTap(){
this.setData({
 show: !this.data.show
});
},
// 点击下拉列表
optionTap(e){
let Index=e.currentTarget.dataset.index;//获取点击的下拉列表的下标
this.setData({
 index:Index,
 show:!this.data.show,
//  index:e.detail.value
});
},
// handleInputChange_account: function(e){
//   this.setData({
//     account:e.detail.value
//   })
//  },
handleInputChange_phone: function(e){
  this.setData({
    phone:e.detail.value
  })
 },
 handleInputChange_userimg: function(e){
  this.setData({
    userimg:e.detail.value
  })
 },
// handleInputChange_password: function(e){
//   this.setData({
//     password:e.detail.value
//   })
//  },
// handleInputChange_confpassword: function(e){
//   this.setData({
//     confpassword:e.detail.value
//   })
//  },
 handleInputChange_age: function(e){
  this.setData({
    age:e.detail.value
  })
 },
handleInputChange_email: function(e){
 this.setData({
   email:e.detail.value
 })
},
handleInputChange_major: function(e){
  this.setData({
    major:e.detail.value
  })
 },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var username=options.username;
    var id=options.id;
    //  var phonenumber=options.phonenumber;
     console.log(username);
     console.log(id);
     var that=this;
    wx.request({
      
      url: "http://192.168.31.48:8080/web/UserServlet", 
      method:"Get",
      data: { 
        method:"getUserByName",
        username:username,
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data), that.setData(
          {userinfo:res.data,
           username1:username,
           id:id
          //  id1:res.data.id,
         })       
      }
    })
  },
  register:function(options){
    
    var that=this;
    wx.request({
      
      url: "http://192.168.31.48:8080/web/UserServlet", 
      method:"Get",
      data: { 
        id:that.data.id,
        method:"userUpdatewx",
     
        // username:this.data.account,
        // password:this.data.password,    
       phonenumber: that.data.phone,
       userimg:that.data.userimg,
        // confpassword:handleInputChange_confpassword,
        age:that.data.age,
        email:that.data.email,
        sex:that.data.sex[that.data.xb].value,
        college:that.data.selectData[that.data.index],
        major:that.data.major
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data),
        that.setData(
          {
            userinfo:res.data,         
          
         })    
      }
    })
    
    // console.log(this.data.index);
    // console.log(this.data.account);
    // console.log(this.data.phone);
    // console.log(this.data.password);
    // console.log(this.data.confpassword);
    // console.log(this.data.age);
    // console.log(this.data.email);
    // console.log(this.data.sex[this.data.xb].value);
    // console.log(this.data.selectData[this.data.index]);
    


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