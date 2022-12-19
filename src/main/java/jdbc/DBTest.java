package jdbc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "DBTest", value = "/DBTest")
public class DBTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "springstudent";
        String pwd = "springstudent";
        String driver = "com.mysql.jdbc.Driver";


        try {
            Class.forName(driver);

            Connection con = DriverManager. getConnection(jdbcURL,user,pwd);

            response.setContentType("text/html");


            // Hello
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "SUCCESSFUL CONNECTION" + "</h1>");
            out.println("</body></html>");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
