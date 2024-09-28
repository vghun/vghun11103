<%@ page import="java.util.*, Product.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/styles.css" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Checkout</h1>
    <table class="checkout-table">
        <thead>
            <tr>
                <th>Description</th>
                <th>quantity</th>
                <th>Price</th>
                <th>amount</th>
            </tr>
        </thead>
        <tbody>
            <%
         
                Map<String, Product> cart = (Map<String, Product>) session.getAttribute("Product");
                double total = 0.0;

                if (cart != null && !cart.isEmpty()) {
                    for (Product item : cart.values()) {
            %>
            <tr>
                <td><%= item.getProductName() %></td>
                <td><%= item.getQuantity() %></td>
                <td>$<%= String.format("%.2f", item.getProductPrice()) %></td>
                <td>$<%= String.format("%.2f", item.getProductPrice() * item.getQuantity()) %></td>
            </tr>
            <%
                        total += item.getProductPrice() * item.getQuantity();
                    }
            %>
            <tr>
                <td colspan="3" style="text-align: right;"><strong>Total Amount:</strong></td>
                <td><strong>$<%= String.format("%.2f", total) %></strong></td>
            </tr>
            <%
                } else {
            %>
            <tr>
                <td colspan="4">No product in cart</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
        <h1> successful payment !! </h1>
    <div class="checkout-actions">
         <button class="button" onclick="window.location.href='clearSession'">Home</button>
    </div>

</body>
</html>
