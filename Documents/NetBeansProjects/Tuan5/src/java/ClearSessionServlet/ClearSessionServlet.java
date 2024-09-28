package ClearSessionServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/ClearSessionServlet")
public class ClearSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xóa toàn bộ session
        HttpSession session = request.getSession();
        session.invalidate();
        
        // Chuyển hướng về trang chính
        response.sendRedirect("index.html");
    }
      @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
                         throws ServletException, IOException {
        doPost(request, response);
    }
}
