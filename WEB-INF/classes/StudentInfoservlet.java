import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Optional: Add @WebServlet for URL mapping

public class StudentInfoservlet extends HttpServlet {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/school";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        ) {
            out.println("<html><head><title>Student Records</title></head><body>");
            out.println("<h2>Student Records</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th></tr>");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                            rs.getString("name") + "</td><td>" +
                            rs.getString("email") + "</td><td>" +
                            rs.getString("course") + "</td></tr>");
            }

            out.println("</table></body></html>");
        } catch (Exception e) {
            out.println("<html><body><h3>Error retrieving student records. Please try again later.</h3>");
            out.println("<pre>" + e.getMessage() + "</pre></body></html>");
        } finally {
            out.close(); // Always close output stream
        }
    }
}
