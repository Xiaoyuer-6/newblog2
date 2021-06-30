import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-06-28
 * Time: 18:10
 */
public class MyCalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.先从前端获取参数
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        int state = -1;//state = 200说明请求正常
        String msg = " ";//错误描述信息
        int sum = 0;
        String num1 = request.getParameter("number1");
        String num2 = request.getParameter("number2");
        //todo:非空校验
        //2.进行相应的业务操作
        if  (num1!= null && num2!= null &&!num1.equals("") &&!num2.equals("")) {
            
            //进行业务处理
            sum = Integer.parseInt(num1) + Integer.parseInt(num2);
            state = 200;
        } else {
            //非法请求，参数传递不全
            msg = "非法请求，参数不全";
        }

        //3.返回结果给前端
        //{"state":%d,"msg":"%s","sum":%d}
        PrintWriter writer = response.getWriter();
        writer.println(String.format("{\"state\":%d,\"msg\":\"%s\",\"sum\":%d}", state, msg, sum));
    }
}