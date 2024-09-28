package YourCart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Đảm bảo rằng lớp CartItem được định nghĩa trong package CartItem
// Nếu không, thay đổi import tương ứng
import Product.Product;

@WebServlet("/CartServlet") // Sử dụng annotation để map Servlet
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                          throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

        // Lấy giỏ hàng từ session hoặc tạo mới nếu chưa có
        HttpSession session = request.getSession();
        Map<String, Product> cart = (Map<String,Product>) session.getAttribute("Product");
        if (cart == null) {
            cart = new HashMap<>();
        }

        // Kiểm tra nếu sản phẩm đã có trong giỏ
        if (cart.containsKey(productName)) {
             Product item = cart.get(productName);  // Lấy đối tượng Product từ giỏ hàng
             item.setQuantity(item.getQuantity()+ 1);  // Tăng số lượng sản phẩm
        } else {
            cart.put(productName, new Product(productName, productPrice));
        }

        // Cập nhật giỏ hàng vào session
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
