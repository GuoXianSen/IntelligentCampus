package action;

import com.alibaba.fastjson.JSONObject;
import dao.GoodsDaoImpl;

import entity.Collect;


import dao.UserDaoImpl;

import entity.Goods;
import entity.GridBean;
import entity.User;
import service.GoodsServiceImpl;
import service.IGoodsService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 商品管理Servlet
 * author: 郭寅之
 */

@WebServlet(name = "GoodsServlet", urlPatterns = "/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    private IGoodsService service= new GoodsServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        System.out.println("==============================>正在请求GoodsServlet的" + method + "方法");
        String json = "";
        Class c = GoodsServlet.class;
        try {
            Method m = c.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            m.invoke(this, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //根据商品名获取所有商品记录
    public void getGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsname = request.getParameter("goodsname");
        if (goodsname != "" && goodsname != null) {
            Goods goods = new Goods();
            GoodsDaoImpl goodsDao = new GoodsDaoImpl();
            goods = goodsDao.getGoodsByName(goodsname);
            if (goodsname.equals(goods.getGoodsname().toString())) {
                String res = JSONObject.toJSONString(goods);
                response.getWriter().println(res);
            } else {
                response.getWriter().println("0");
            }
        } else {
            response.getWriter().println("0");
        }
    }
    //后台web端获取所有信息
    public void getAllgoods1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");


        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        //查询总数量
        int count = service.findCountGoodsEasy();
        //查询当页得到数据
        List<Goods> list = service.findGoodsEasyPage(page,limit);
        System.out.println(page + "  " + limit);
        //调用service获取所有用户数据
        GridBean<Goods> bean = new GridBean<>(200,"请求成功",count,list);
        //json  jackson  fastjson
        String json = JSONObject.toJSONString(bean);
        System.out.println(json);
        //String
        //String s = "[{name:\"xiaowang\"},{name:\"xiaozhang\"}]";
        response.getWriter().println(json);
    }

    //获取所有商品信息
    public void getAllgoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        GoodsDaoImpl userDao=new GoodsDaoImpl();
        List<Goods> goods=userDao.GetAllGoods();
        if (goods!=null) {
            String res=JSONObject.toJSONString(goods);
            response.getWriter().println(res);
        }else{
            response.getWriter().println("0");
        }
    }

    /**
     * 添加一个商品
     * 修改人：郭寅之
     * @param request
     * @param response
     * @throws IOException
     */
    public void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsname=request.getParameter("goodsname");
        String goodsprice=request.getParameter("goodsprice");
        String goodsnum1=request.getParameter("goodsnum");
        int goodsnum=Integer.parseInt(goodsnum1);
        String goodscode=request.getParameter("goodscode");
        String createtime=request.getParameter("createtime");
        String updatedtime=request.getParameter("updatedtime");
        String goodsimg=request.getParameter("goodsimg");
        GoodsDaoImpl goodsdao=new GoodsDaoImpl();
        Goods goods2=new Goods();
        //商品名不能为空
        if (goodsname!=""&&goodsname!=null){
            Goods goods1 = goodsdao.getGoodsByName(goodsname);

            //判断是否存在相同商品
            //此处为不存在相同商品的情况
            if (goods1==null) {
                Goods goods = new Goods();
                goods.setGoodsname(goodsname);
                goods.setGoodsnum(goodsnum);
                goods.setGoodsprice(goodsprice);
                goods.setCreatetime(createtime);
                goods.setUpdatedtime(updatedtime);
                goods.setGoodsimg(goodsimg);
                goods.setGoodscode(goodscode);
                goods2 =goodsdao.Insert(goods);
                System.out.println(goods2);
                response.getWriter().println("1");
            }else {
                response.getWriter().println("0");
            }
        }else{
            response.getWriter().println("0");
        }
    }

    //添加收藏
    public void addCollect(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String username=request.getParameter("username");
       String goodsname=request.getParameter("goodsname");
       String goodsimg=request.getParameter("goodsimg");
       String goodsprice=request.getParameter("goodsprice");
       Collect collect=new Collect();
       collect.setUsername(username);
       collect.setGoodsname(goodsname);
       collect.setGoodsimg(goodsimg);
       collect.setGoodsprice(goodsprice);
       GoodsDaoImpl goodsdao=new GoodsDaoImpl();
       Collect res=goodsdao.Addcollect(collect);
       String col=JSONObject.toJSONString(res);
       if (col!=null&&col!=""){
           response.getWriter().println("1");
       }else{
           response.getWriter().println("0");
       }


    }
    //根据用户名获取商品收藏信息
    public void getCollect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        GoodsDaoImpl goodsdao=new GoodsDaoImpl();
        List<Collect> collect=goodsdao.Getcollect(username);
        String res=JSONObject.toJSONString(collect);
        if (res!=null&&res!=""){
            response.getWriter().println(res);
        }else{
            response.getWriter().println("0");
        }
    }
    //删除收藏
    public void deleteCollect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsid1=request.getParameter("goodsid");
        int goodsid=0;
        if (goodsid1!=null&&goodsid1!="") {
           goodsid=Integer.parseInt(goodsid1);
        }
        GoodsDaoImpl goodsdao = new GoodsDaoImpl();
        int res=goodsdao.Deletecollect(goodsid);
        if (res>0) {
            response.getWriter().println("1");
        }else{
            response.getWriter().println("0");
        }


    }





    /**
     * 删除商品的方法
     * 创建人：郭寅之
     * @param request
     * @param response
     * @throws IOException
     */
    public void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsid = request.getParameter("goodsid");
        //判断id是否为空
        if (goodsid!=""&&goodsid!=null) {
            GoodsDaoImpl goodsDao = new GoodsDaoImpl();
            int id = Integer.parseInt(goodsid);
            int res = goodsDao.GoodsDelete(id);
            if (res == 1) {
                response.getWriter().println("删除成功 code:1");
            } else {
                response.getWriter().println("删除失败 code:0");
            }
        }else {
            response.getWriter().println("删除失败，id为空 code:0");
        }

    }
     //修改商品
    public void updateGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsid = request.getParameter("goodsid");
        //判断id是否为空
        if (goodsid!=""&&goodsid!=null) {
            int id = Integer.parseInt(goodsid);
            Goods goods = new Goods();
            goods.setGoodsid(id);
            goods.setGoodsname(request.getParameter("goodsname"));
            goods.setGoodsprice(request.getParameter("goodsprice"));
            goods.setGoodsnum(Integer.parseInt(request.getParameter("goodsnum")));
            goods.setGoodsstatus(request.getParameter("goodsstatus"));
            goods.setCreatetime(request.getParameter("createtime"));
            goods.setUpdatedtime(request.getParameter("updatedtime"));
            goods.setGoodscode(request.getParameter("goodscode"));
            goods.setGoodsimg(request.getParameter("goodsimg"));

            GoodsDaoImpl goodsDao = new GoodsDaoImpl();

            int res = goodsDao.GoodsUpdate(goods);
            if (res == 0) {
                response.getWriter().println("更新失败 code:0");
            } else {
                response.getWriter().println("更新成功 code:1");
            }
        }else {
            response.getWriter().println("更新出错了 code:-1");
        }
    }


}


