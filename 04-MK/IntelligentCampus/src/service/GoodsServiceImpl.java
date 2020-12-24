package service;

import dao.GoodsDaoImpl;
import dao.IGoodsDao;

import entity.Goods;
import entity.User;

import java.util.List;

public class GoodsServiceImpl implements IGoodsService{
    private IGoodsDao dao = new GoodsDaoImpl();


    @Override
    public List<Goods> findGoodsEasy() {
        return null;
    }

    @Override
    public User findGoodsByID(int id) {
        return null;
    }

    @Override
    public int findCountGoodsEasy() {
        return dao.findCountGoodsEasy();
    }

    @Override
    public List<Goods> findGoodsEasyPage(String page, String limit) {
        int pageI = Integer.parseInt(page);
        int limitI =Integer.parseInt(limit);
        int from =(pageI-1)*limitI;
        return dao.findGoodsEasyPage(from,limitI);
    }
}
