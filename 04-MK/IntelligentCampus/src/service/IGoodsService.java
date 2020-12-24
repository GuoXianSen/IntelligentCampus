package service;

import entity.Goods;
import entity.User;

import java.util.List;

public interface IGoodsService {
    List<Goods> findGoodsEasy();

    User findGoodsByID(int id);

    int findCountGoodsEasy();

    List<Goods> findGoodsEasyPage(String page, String limit);
}
