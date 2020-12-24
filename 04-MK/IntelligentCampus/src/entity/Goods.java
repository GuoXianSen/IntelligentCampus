package entity;

public class Goods {
    private int goodsid;        //商品id
    private String goodsname;   //商品名
    private int goodsnum;       //商品数量
    private String goodsprice;  //商品价格
    private String goodsstatus; //商品状态
    private String createtime;  //创建时间
    private String updatedtime; //更新时间
    private String goodscode;   //商品码
    private String goodsimg;    //商品图片

    @Override
    public String toString() {
        return "Goods{" +
                "goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", goodsnum=" + goodsnum +
                ", goodsprice='" + goodsprice + '\'' +
                ", goodsstatus='" + goodsstatus + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatedtime='" + updatedtime + '\'' +
                ", goodscode='" + goodscode + '\'' +
                ", goodsimg='" + goodsimg + '\'' +
                '}';
    }

    public Goods(int goodsid, String goodsname, int goodsnum, String goodsprice, String goodsstatus, String createtime, String updatedtime, String goodscode, String goodsimg) {
        this.goodsid = goodsid;
        this.goodsname = goodsname;
        this.goodsnum = goodsnum;
        this.goodsprice = goodsprice;
        this.goodsstatus = goodsstatus;
        this.createtime = createtime;
        this.updatedtime = updatedtime;
        this.goodscode = goodscode;
        this.goodsimg = goodsimg;
    }

    public Goods() {
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public String getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsstatus() {
        return goodsstatus;
    }

    public void setGoodsstatus(String goodsstatus) {
        this.goodsstatus = goodsstatus;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(String updatedtime) {
        this.updatedtime = updatedtime;
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }
}
