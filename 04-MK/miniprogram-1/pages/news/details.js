// pages/news/details.js
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
    var key=options.id;
    console.log(key);
    var details = [
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
      {
        id:"3",
        img:"/pages/img/3.jpg",
        title:"树人生报国志 开变局之新局 我校2020级新生开学典礼隆重举行",
        updatetime:"2020/09/25",
        content:"天高云淡，碧空澄净。9月25日上午，我校2020级新生开学典礼在辽河路校区体育场馆拉开帷幕。在做好常态化疫情防控措施的基础上，全体校领导，相关职能部门负责人，各二级学院党政领导、新生辅导员，校学生会主席与4100余名新生汇聚一堂，共同见证新生大学生活正式打开。校党委副书记王传金主持典礼。",
      },
    ]
    for(var i=0;i<details.length;i++){
      if(details[i].id==key){
        this.setData({
          details:details[i]
        });
      }
    }
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