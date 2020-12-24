package entity;

public class Collect {

    private String goodsid;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "goodsid='" + goodsid + '\'' +
                ", username='" + username + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", goodsprice='" + goodsprice + '\'' +
                ", goodsimg='" + goodsimg + '\'' +
                '}';
    }

    public Collect(String goodsid, String username, String goodsname, String goodsprice, String goodsimg) {
        this.goodsid = goodsid;
        this.username = username;
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
        this.goodsimg = goodsimg;
    }

    private String username;//收藏者
    private String goodsname;//商品名
    private String goodsprice;//商品价格

    public Collect(String username, String goodsname, String goodsprice, String goodsimg) {
        this.username = username;
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
        this.goodsimg = goodsimg;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }

    private String goodsimg;//商品图片

    public Collect(){}
    public Collect(String username, String goodsname, String goodsprice) {
        this.username = username;
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }


}
