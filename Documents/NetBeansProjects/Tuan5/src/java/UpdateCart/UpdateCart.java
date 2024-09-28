package UpdateCart;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Map;
import Product.Product;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));

        // Lấy giỏ hàng từ session
        HttpSession session = request.getSession();
        Map<String, Product> cart = (Map<String, Product>) session.getAttribute("Product");

        if (cart != null && cart.containsKey(productName)) {
            // Cập nhật số lượng của sản phẩm
            Product item = cart.get(productName);
            item.setQuantity(newQuantity);
        }

        // Cập nhật lại giỏ hàng vào session
        session.setAttribute("Product", cart);

        // Chuyển hướng về trang giỏ hàng
        response.sendRedirect("viewCart.jsp");
    }
     @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
                         throws ServletException, IOException {
        doPost(request, response);
    }
}
