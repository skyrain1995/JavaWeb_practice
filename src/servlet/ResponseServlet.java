package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Response对象学习
 * 作用：响应数据到浏览器的一个对象
 * 使用：设置响应头
 * resp.setHeader(String name,String value);  //在响应头中添加响应信息，但是同一个键会覆盖
 * resp.addHeader(String name,String value);  //在响应头中添加响应信息，不会覆盖
 * 响应实体
 * resp.getWriter().write(String str);
 * 总结：
 *  service请求处理代码流程：
 *  设置响应编码格式
 *  获取请求数据
 *  处理请求数据（数据库操作，MVC思想）
 *  响应处理结果
 */
@WebServlet(name = "ResponseServlet")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求信息

        //处理请求

        //响应处理结果
        //设置响应头
        resp.setHeader("mouse","xiaomi");    //实际要写http协议中的键值对
        resp.addHeader("key","lenovo");
        //设置相应编码格式
        //resp.setHeader("content-type","text/html;charset=utf-8");
        //resp.setContentType("text/plain;charset=utf-8");  //发送的为普通文本
        //resp.setContentType("text/xml;charset=utf-8");    //发送的为xml格式
        resp.setContentType("text/html;charset=utf-8");
        //设置响应状态码
        //resp.sendError(404,"sorry");
        //设置响应实体
        resp.getWriter().write("this is response study");
    }
}
