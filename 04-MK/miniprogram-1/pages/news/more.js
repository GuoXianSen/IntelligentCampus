// pages/news/more.js
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
    var newsList = [
      {
        id:"1",
        img:"/pages/img/1.jpg",
        title:"抢抓机遇 聚力担当 努力开创学校事业高质量发展新局面",
        updatetime:"2020/11/21",
        content:"1月20日下午至21日，肩负全校师生的重托，满怀履职尽责的使命感和责任感，我校教职工、工会会员正式代表和列席代表百余人汇聚一堂，共襄“十四五”期间学校事业高质量发展。",
      },
      {
        id:"2",
        img:"/pages/img/2.jpg",
        title:"常州市委书记齐家滨一行来校视察调研",
        updatetime:"2020/11/18",
        content:"11月18日上午，常州市委书记齐家滨，市委常委、宣传部部长陈涛，市委常委、市委秘书长方国强，副市长陈正春，市委副秘书长、研究室主任吉英平，市政府副秘书长刘文荣等来校视察调研。市教育局、财政局、人社局等单位领导陪同。我校领导曹雨平、汤正华、周全法、朱海山、党委办公室/院长办公室负责人参加调研交流。",
      },
    ]
    this.setData({
      newsList:newsList,
    });
  },

  detail:function(e){
    var id = e.currentTarget.dataset.id;
    // console.log(id);
    wx.navigateTo({
      url: '/pages/news/details?id='+id,
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