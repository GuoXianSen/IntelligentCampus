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
   var shoucang1=this.data.shouji+"/zshoucang1.png"
   this.setData({
     shoucang:shoucang1,
     i:1
   })
    var key=options.id;
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
        for(var i=0;i<res.data.length;i++){
          if(key==res.data[i].goodsid){
         that.setData({
            detail:res.data[i],          
         })    
        }
        }            
      },
    })
  //   var detail=[{
  //     id:"1",
  //     imgsrc:["/images/1.jpg","/images/1.jpg"],
  //     title:"三个先生韩式甜辣炸鸡",
  //     price:"￥49.8",   
  //   },
  //   {
  //     id:"2",
  //     imgsrc:["/images/2.jpg","/images/2.jpg"],
  //     title:"可口可乐",
  //     price:"￥3",   
  //   },
  //   {
  //     id:"3",
  //     imgsrc:["/images/3.jpg","/images/3.jpg"],
  //     title:"辣条",
  //     price:"￥2",   
  //   },
  //   {
  //     id:"4",
  //     imgsrc:["/images/4.jpg","/images/4.jpg"],
  //     title:"奶茶",
  //     price:"￥15",   
  //   },
  // ]
  //   for(var i=0;i<detail.length;i++){
  //     if(detail[i].id==key){
  //       this.setData({
  //         Detail:detail[i]
  //       });
  //     }
  //   }
  // },
  // goodsObj: [], //存储数据的数组
  // isCollect: false,//表示是否被收藏过。
  // GoodsInfo: {},   //商品对象
  // async getGoodsDetail(goods_id) {
  //   const goodsObj = await request({
  //     url: "/goods/detail",
  //     data: { goods_id },
  //   });
  //   console.log(goodsObj);
  //   this.GoodsInfo = goodsObj;
  //   //获取缓存中收藏的数组
  //   let collect = wx.getStorageSync("collect") || [];
  //   let isCollect = collect.some((v) => v.goods_id === this.GoodsInfo.goods_id);
  //   this.setData({
  //     goodsObj: {
  //       goods_name: goodsObj.goods_name,
  //       goods_price: goodsObj.goods_price,
  //       //在获取返回的数据当中存在webp图片格式，将其转化为jpg格式
  //       goods_introduce: goodsObj.goods_introduce.replace(/\.webp/g, ".jpg"),
  //       pics: goodsObj.pics,
  //     },
  //   });
  },
  onShow: function (options) {
    
  },
  shoucang:function(e){
    var that=this;
    var imgsrc=[that.data.shouji+"/zshoucang1.png",that.data.shouji+"/zshoucang2.png"]   
    if(this.data.i==0){
      var res=imgsrc[this.data.i]
      console.log(res)
      that.setData({
        shoucang:res,
        i:1
      })       
    }else{      
      var res=imgsrc[this.data.i]
      that.setData({
        shoucang:res,
        i:0       
      })
      
    }

  },
  carttab:function(e){
    wx.switchTab({
      url: '../cart1/cart1',
    })

  },
  btn_cart:function(e){
    wx.request({
      url: this.data.shouji+'/GoodsServlet',
      data:{
        method:"addCollect",
        username:"dly",
        goodsname:this.data.detail.goodsname,
        goodsprice:this.data.detail.goodsprice,
        goodsimg:this.data.detail.goodsimg
      },
      success:function(res){
        console.log(res.data);
        wx.showToast({
          title: '添加成功',
          icon:'success',
          duration: 1500
        })
      }
    })
  },
  //立即购买
  
  btn_buy:function(e){   
    var goodsname=e.currentTarget.dataset.goodsname;
    console.log(goodsname);
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
        wx.showToast({
          title: '购买成功',
          icon:'success',
          duration: 2000
        })
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

})