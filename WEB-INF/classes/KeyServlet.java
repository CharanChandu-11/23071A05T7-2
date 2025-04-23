import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class KeyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String fn= firstname.length() >=2 ? firstname.substring(0, 2) : firstname;
        String ln= lastname.length() >=2 ? lastname.substring(0, 2) : lastname;
        String key=fn+ln;
        out.println("<html><body>");
        out.println("<h2>Generated Key</h2>");
        out.println("<p>First Name: " + firstname + "</p>");
        out.println("<p>Last Name: " + lastname + "</p>");
        out.println("<p>Generated Key: " + key + "</p>");
        out.println("</body></html>");
    }
}
