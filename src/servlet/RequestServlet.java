package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * request对象学习：
 * request对象封存了当前请求的所有请求信息
 * 使用：获取请求头，请求行，用户数据
 * 注：request对象由服务器创建，并作为实参传递给处理请求的servlet的service方法
 */
@WebServlet(name = "RequestServlet")
public class RequestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头数据
        //1.获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        //2.获取请求url
        StringBuffer url = req.getRequestURL();
        System.out.println(url);
        //3.获取请求协议
        String h = req.getScheme();
        System.out.println(h);

        //获取指定请求行数据
        String value = req.getHeader("User-Agent");
        System.out.println(value);
        //获取所有的请求行
        Enumeration e = req.getHeaderNames();
        while(e.hasMoreElements()){
            String name = (String) e.nextElement();
            String value2 = req.getHeader(name);
            System.out.println(name+":"+value2);
        }

        //获取用户数据
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(name+":"+pwd);
        //req.getParameterNames();     //返回所有用户请求数据的枚举集合
        //req.getParameterValues("键名");    //返回同键不同值的请求数据，返回的是数组
    }
}
