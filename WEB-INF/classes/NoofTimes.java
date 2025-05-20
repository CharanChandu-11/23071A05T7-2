import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
public class NoofTimes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        session.setAttribute("count", count);
        session.setAttribute("username", username);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Hello, " + username + "!</h2>");
        out.println("<p>You have logged in " + count + " times.</p>");
    
}
}