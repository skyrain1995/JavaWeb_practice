package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Service方法和doPost和doGet方法的区别
 * Service方法:可以处理get/post方式的请求，如果servlet中有Service方法，会优先调用Service方法对请求进行处理
 * doGet方法：处理get方式的请求
 * doPost方法：处理post方式的请求
 * 注意：
 * 如果重写的service方法中调用了父类的service方法super.service(req, resp);
 * 则service方法处理完后，会再次根据请求方式调用相应的doPost或doGet方法
 * 所以一般情况下是不在重写的service方法中调用父类的service方法，避免405错误
 */
@WebServlet(name = "ServletMethod")
public class ServletMethod extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是service");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是get方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是post方法");
    }
}
