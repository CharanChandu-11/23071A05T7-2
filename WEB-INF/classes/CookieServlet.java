import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create 4 simple cookies
        Cookie cookie1 = new Cookie("user", username);
        Cookie cookie2 = new Cookie("pass", password);
        Cookie cookie3 = new Cookie("loginTime", "" + System.currentTimeMillis());
        Cookie cookie4 = new Cookie("loggedIn", "true");

        // Add them to response
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addCookie(cookie4);

        // Display cookies in HTML table
        out.println("<html><body>");
        out.println("<h2>Cookies Created:</h2>");
        out.println("<table border='1'><tr><th>Cookie Name</th><th>Value</th></tr>");
        out.println("<tr><td>" + cookie1.getName() + "</td><td>" + cookie1.getValue() + "</td></tr>");
        out.println("<tr><td>" + cookie2.getName() + "</td><td>" + cookie2.getValue() + "</td></tr>");
        out.println("<tr><td>" + cookie3.getName() + "</td><td>" + cookie3.getValue() + "</td></tr>");
        out.println("<tr><td>" + cookie4.getName() + "</td><td>" + cookie4.getValue() + "</td></tr>");
        out.println("</table></body></html>");

        out.close();
    }
}
