package action;

import com.alibaba.fastjson.JSONObject;
import dao.HealthCodeImpl;

import entity.HealthCode;


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
@WebServlet(name = "HealthCodeServlet", urlPatterns = "/HealthCodeServlet")
public class HealthCodeServlet extends HttpServlet {

//    private IUserService service = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("method");
        System.out.println("======================>正在请求HealthCodeServlet的" + method + "方法");
        String json = "";
        Class c = HealthCodeServlet.class;
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
     * 健康码添加
     * @param request
     * @param response
     * @throws IOException
     */
    public void addHealthCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String healthstatus = request.getParameter("healthstatus");
        String healthcodeimg = request.getParameter("healthcodeimg");
        String healthInfo=request.getParameter("healthInfo");

        HealthCode hc = new HealthCode();
        HealthCode res = new HealthCode();
//        HealthCode hc1 = new HealthCode();
        hc.setUsername(username);
        hc.setHealthstatus(healthstatus);
        hc.setHealthcodeimg(healthcodeimg);
        hc.setHealthInfo(healthInfo);

        HealthCodeImpl healthCode = new HealthCodeImpl();

        res = healthCode.AddHealthCode(hc);
        response.getWriter().println(res);
//        //判断账号密码是否为空
//        if (username!=null || username!=""){
//                hc = userDao.getUserByName(username);
//                //判断数据库是否存在相同用户
//                if (res==null){
//                    user.setUsername(username);
//                    user.setPassword(password);
//                    user.setEmail(email);
//                    user.setSex(sex);
//                    user.setCollege(college);
//                    user.setUserimg(userimg);
//                    user.setMajor(major);
//                    user.setAge(age1);
//                    user.setPhonenumber(phonenumber);
//                    res1=userDao.Insert(user);
//                    response.getWriter().println("1");
//                }else{
//                    response.getWriter().println("-1");
//                }
//            }
    }

    /**
     * 健康码 获取所有用户
     * @param request
     * @param response
     * @throws IOException
     */
    public void getAllHealthCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HealthCodeImpl healthCode =new HealthCodeImpl();
        List<HealthCode> res = healthCode.getAllHealthCode();
        String result= JSONObject.toJSONString(res);
        response.getWriter().println(result);
    }

    /**
     * 通过id获取用户信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void getHealthCodeByID(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }

    /**
     * 通过ID来删除健康码信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void deleteHealthCodeByID(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userid = request.getParameter("userid");
        //判断id是否为空
        if (userid!=""&&userid!=null) {
            HealthCodeImpl healthCode = new HealthCodeImpl();

            int id = Integer.parseInt(userid);
            int res = healthCode.DeleteHealthCode(id);

            if (res == 1) {
                response.getWriter().println("删除成功 code:1");
            } else {
                response.getWriter().println("删除失败 code:0");
            }
        }else {
            response.getWriter().println("删除失败，id为空 code:0");
        }
    }

}