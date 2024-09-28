package RemoveProduct;

import java.io.IOException;
import java.util.Map;
import Product.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RemoveProduct")
public class RemoveProduct extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Lấy session
        HttpSession session = request.getSession();
        
        // Lấy giỏ hàng từ session
        Map<String, Product> cart = (Map<String, Product>) session.getAttribute("Product");
        
        // Lấy tên sản phẩm cần xóa từ request
        String productName = request.getParameter("productName");
        
        // Kiểm tra xem giỏ hàng có tồn tại không và xóa sản phẩm
        if (cart != null && cart.containsKey(productName)) {
            cart.remove(productName);  // Xóa sản phẩm khỏi giỏ hàng
        }
        
        // Cập nhật lại giỏ hàng trong session
        session.setAttribute("Product", cart);
        
        // Chuyển hướng trở lại trang giỏ hàng
        response.sendRedirect("viewCart.jsp");
    }
}
