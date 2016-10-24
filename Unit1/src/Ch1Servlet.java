import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Jax on 2016/10/24.
 */
public class Ch1Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException {
        PrintWriter out = response.getWriter();
        java.util.Date today = new java.util.Date();
        out.println("<html>" +
                    "<body>" +
                    "<h1 align=center>HF\'s Chapter1 Sevrlet</h1>" +
                    "<br>" + today + "</body>" + "</html>");
    }
}
