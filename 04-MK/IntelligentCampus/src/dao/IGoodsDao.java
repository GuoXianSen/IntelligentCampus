package dao;



import entity.Goods;
import entity.User;
import entity.Collect;

import java.util.List;

public interface IGoodsDao {
    //删除收藏
    int Deletecollect(int goodsid);
    //添加收藏
    Collect Addcollect(Collect collect);
    //获取收藏信息
    List<Collect> Getcollect(String username);
    //添加用户
    Goods Insert(Goods goods);

    //通过ID查询用户
    Goods GetGoodsByID(int id);

    //通过用户名查询用户
    Goods getGoodsByName(String name);

    //获取所有用户
    List<Goods> GetAllGoods();

    //账号密码登录校验
    Goods GetGoodsByNamePwd(String username,String password);

    //删除用户
    int GoodsDelete(int goodsid);

    //更新用户
    int GoodsUpdate(Goods goods);

    int findCountGoodsEasy();
    List<Goods> findGoodsEasyPage(int from, int limitI);

}
