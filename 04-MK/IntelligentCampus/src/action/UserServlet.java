package action;


import com.alibaba.fastjson.JSONObject;
import dao.UserDaoImpl;
import entity.GridBean;
import entity.User;
import service.IUserService;
import service.UserServiceImpl;

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
 * 用户管理
 *     用户登录
 *     用户注册
 * author:郭寅之&丁路遥
 */
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {

    private IUserService service= new UserServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("method");
        System.out.println("===========>正在请求UserServlet的" + method + "方法");
        String json = "";
        Class c = UserServlet.class;
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
    /**
     * 用户登录方法
     * @param request
     * @param response
     * @throws IOException
     */
    public void userLogin1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username==null || password==null) {
            response.getWriter().println("账号或密码为空" + "-1");
        }else{
        if (username.equals("") || password.equals("")) {
            response.getWriter().println("账号或密码为空" + "-1");
        } else {
            UserDaoImpl userDao = new UserDaoImpl();
            User resList = new User();
            resList = userDao.GetUserByNamePwd(username,password);
            if (resList ==null){
                response.getWriter().println("登录失败，code:0");
            }else {
                if (username.equals(resList.getUsername()) && password.equals(resList.getPassword())){
                    response.getWriter().println("1");
                }
            }
//            System.out.println(resList.getUsername().toString() + "\n" + resList.getPassword().toString());
//
//            if (username.equals(resList.getUsername()) && password.equals(resList.getPassword())) {
//                response.getWriter().println("登录成功，code:1");
//            } else if (resList.getUsername().equals("")){
//                response.getWriter().println("登录失败，code:0");
//            }
//        if (username.equals(nlist.getUsername())&& password.equals(nlist.getPassword())){
//            response.getWriter().println("登录成功！"+ "status:1");
//        }else {
//            response.getWriter().println("登录失败！"+"status:0");
//        }
        }}
    }
    /**
     * 用户注册方法
     * @param request
     * @param response
     * @throws IOException
     */
    public void userRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        int age1=0;
        if(age!=""&&age!=null){
            age1=Integer.parseInt(age);
        }
        String college=request.getParameter("college");
        String major=request.getParameter("major");
        String phonenumber=request.getParameter("phonenumber");
        String userimg=request.getParameter("userimg");
        User res = new User();
        User res1 = new User();
        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();
        //判断账号密码是否为空
        if (username!=null&&password!=null){
        if (username!=""&&password!="") {
            res=userDao.getUserByName(username);
        //判断数据库是否存在相同用户
        if (res==null){
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setSex(sex);
            user.setCollege(college);
            user.setUserimg(userimg);
            user.setMajor(major);
            user.setAge(age1);
            user.setPhonenumber(phonenumber);
            res1=userDao.Insert(user);
            response.getWriter().println("1");
        }else{
            response.getWriter().println("-1");
        }
        }else{
            response.getWriter().println("0");
        }
    }else{
            response.getWriter().println("0");
        }
    }


    //根据用户id删除一条记录
    public void userDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userid = request.getParameter("id");
        //判断id是否为空
        if (userid!=""&&userid!=null) {
            UserDaoImpl userDao = new UserDaoImpl();
            int id = Integer.parseInt(userid);
            int res = userDao.UserDelete(id);
            if (res == 1) {
                response.getWriter().println("删除成功 code:1");
            } else {
                response.getWriter().println("删除失败 code:0");
            }
        }else {
            response.getWriter().println("删除失败，id为空 code:0");
        }
    }

    /**
     * 获取所有用户信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void getAlluser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
//        UserDaoImpl userDao=new UserDaoImpl();
//        List<User> res=userDao.GetAllUser();
//        //返回json字符串
//        String jsonres = JSONObject.toJSONString(res);
//        response.getWriter().println(jsonres);
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        //查询总数量
        int count = service.findCountUserEasy();
        //查询当页得到数据
        List<User> list = service.findUserEasyPage(page,limit);
        System.out.println(page + "  " + limit);
        //调用service获取所有用户数据
        GridBean<User> bean = new GridBean<>(200,"请求成功",count,list);
        //json  jackson  fastjson
        String json = JSONObject.toJSONString(bean);
        System.out.println(json);
        //String
        //String s = "[{name:\"xiaowang\"},{name:\"xiaozhang\"}]";
        response.getWriter().println(json);
    }
    //简单查询所有用户信息
    public void getAlluser1 (HttpServletRequest request, HttpServletResponse response) throws IOException{
        UserDaoImpl userDao=new UserDaoImpl();
        List<User> res=userDao.GetAllUser();
        String result=JSONObject.toJSONString(res);
        response.getWriter().println(result);

    }

    /**
     * 根据id实现用户更新
     * @param request
     * @param response
     * @throws IOException
     */
    public void userUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userid = request.getParameter("id");
        //判断id是否为空
        if (userid!=""&&userid!=null) {
            int id = Integer.parseInt(userid);
            User user = new User();
            user.setId(id);
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setSex(request.getParameter("sex"));
            user.setAge(Integer.parseInt(request.getParameter("age")));
            user.setPhonenumber(request.getParameter("phonenumber"));
            user.setCollege(request.getParameter("college"));
            user.setMajor(request.getParameter("major"));
            user.setEmail(request.getParameter("email"));
            user.setUserimg((request.getParameter("userimg")));

            UserDaoImpl userDao = new UserDaoImpl();

            int res = userDao.UserUpdate(user);
            if (res == 0) {
                response.getWriter().println("更新失败 code:0");
            } else {
                response.getWriter().println("更新成功 code:1");
            }
        }else {
            response.getWriter().println("更新失败 code:-1");
        }
    }
    //根据id小程序端实现编辑页面
    public void userUpdatewx(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userid = request.getParameter("id");
        //判断id是否为空
        if (userid!=""&&userid!=null) {
            int id = Integer.parseInt(userid);
            User user = new User();
            user.setId(id);
            user.setSex(request.getParameter("sex"));
            user.setAge(Integer.parseInt(request.getParameter("age")));
            user.setPhonenumber(request.getParameter("phonenumber"));
            user.setCollege(request.getParameter("college"));
            user.setMajor(request.getParameter("major"));
            user.setEmail(request.getParameter("email"));
            user.setUserimg((request.getParameter("userimg")));

            UserDaoImpl userDao = new UserDaoImpl();

            int res = userDao.UserUpdatewx(user);
            if (res == 0) {
                response.getWriter().println("更新失败 code:0");
            } else {
                response.getWriter().println("更新成功 code:1");
            }
        }else {
            response.getWriter().println("更新失败 code:-1");
        }
    }
    //根据id修改密码
    public void psdUpdatewx(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userid = request.getParameter("id");
        //判断id是否为空
        if (userid!=""&&userid!=null) {
            int id = Integer.parseInt(userid);
            User user = new User();
            user.setId(id);
            user.setPassword(request.getParameter("password"));
            UserDaoImpl userDao = new UserDaoImpl();
            int res = userDao.PsdUpdatewx(user);
            if (res == 0) {
                response.getWriter().println("更新失败 code:0");
            } else {
                response.getWriter().println("更新成功 code:1");
            }
        }else {
            response.getWriter().println("更新失败 code:-1");
        }
    }

    //通过username获取一条数据
    public void getUserByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        if (username!=null&&username!=""){
            User res=new User();
            UserDaoImpl userDao=new UserDaoImpl();
            res=userDao.getUserByName(username);
            if (res!=null){
                String result=JSONObject.toJSONString(res);
                response.getWriter().println(result);
            }else{
                response.getWriter().println("1");
            }
        }else{
                response.getWriter().println("0");
        }

    }
}



