//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    shouji:app.globalData.shouji,
   imgSrc:["/images/lunbo-1.jpg","/images/lunbo-2.jpg","/images/lunbo-3.jpg"],
   fenlei:[app.globalData.shouji+"/zwaimai.png",app.globalData.shouji+"/zlingshi.png",app.globalData.shouji+"/zyinliao.png"],
   list:[],
   page:1,
   limit:"5"
  //  waimai:"/images/外卖.png",
  //  lingshi:"/images/零食.png",
  //  yinliao:"/images/饮料.png",
  },
  //事件处理函数
  bindViewTap: function() {   
  },
  onLoad: function (options) {
    console.log(app.globalData.shouji);
   var that=this;
    wx.request({     
      url:this.data.shouji+'/GoodsServlet',
      method:"get",
      data:{
        method:"getAllgoods1",
        page:that.data.page,
        limit:that.data.limit
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success:function(res){
        // console.log(res.data);
        var p=++that.data.page
         that.setData({
            list:res.data.rows,
            page:p       
         })         
      },
    })  
  },
  //点击跳转商品详细页面
  detail: function(e){
    var id=e.currentTarget.dataset.id;   
    wx.navigateTo({
      url: '/pages/detail/detail?id='+id   
    })
  },
  //点击跳转外卖页面
  waimai:function(e){
    wx.navigateTo({
      url: '/pages/waimai/waimai'     
    })
  },  // 点击跳转零食页面
  lingshi:function(e){
    wx.navigateTo({
      url: '/pages/lingshi/lingshi'     
    })
  },
  //点击跳转饮料分类页面
  yinliao:function(e){
    wx.navigateTo({
      url: '/pages/yinliao/yinliao'     
    })
  },
  onReachBottom:function(e){
    var that=this;
    wx.request({
      url: this.data.shouji+'/GoodsServlet',
      method:"get",
      data:{
        method:"getAllgoods1",
        page:that.data.page,
        limit:that.data.limit
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success:function(res){
        // console.log(res.data);
        var arr=that.data.list    
        if(res.data.rows!=""){
          var p=++that.data.page
          for(var i=0;i<res.data.rows.length;i++){
            arr.push(res.data.rows[i])
          }    
        }else{
          var p=that.data.page
        }       
        console.log(arr)             
        that.setData({
         list:arr,
         page:p
      })
      },
    })  
  },
  //监听页面显示
  onShow: function () {
  //   var that=this;
  //   wx.request({
      
  //     url:this.data.shouji+'/GoodsServlet',
  //     method:"get",
  //     data:{
  //       method:"getAllgoods1",
  //       page:that.data.page,
  //       limit:that.data.limit
  //     },
  //     header: {
  //       'content-type': 'application/json' // 默认值
  //     },
  //     success:function(res){
  //       // console.log(res.data);
  //       var p=++that.data.page
  //        that.setData({
  //           list:res.data.rows,
  //           page:p       
  //        })         
  //     },
  //   })  
  },
  //下拉刷新
  onPullDownRefresh(){
    console.log("下拉中");
    var that=this;
    wx.request({
      url: this.data.shouji+'/GoodsServlet',
      method:"get",
      data:{
        method:"getAllgoods1",
        page:"1",
        limit:"5"
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success:function(res){
        // console.log(res.data);
        // var arr=that.data.list    
        // if(res.data.rows!=""){
        //   var p=++that.data.page
        //   for(var i=0;i<res.data.rows.length;i++){
        //     arr.push(res.data.rows[i])
        //   }    
        // }else{
        //   var p=that.data.page
        // }       
        // console.log(arr)             
        that.setData({
         list:res.data.rows
         
      })
      },
    })  

  }



})
