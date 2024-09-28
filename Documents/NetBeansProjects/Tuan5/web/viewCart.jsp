<%@ page import="java.util.*, Product.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/styles.css" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
 <script>
        var originalValues = {};

        // L?u giá tr? g?c khi ng??i dùng b?t ??u s?a ??i
        function storeOriginalValue(productName, quantity) {
            originalValues[productName] = quantity;
        }

        // Khôi ph?c giá tr? c? n?u ng??i dùng không b?m Update
        function restoreOriginalValue(productName) {
            var inputField = document.querySelector(`input[name='quantity'][value='${productName}']`);
            inputField.value = originalValues[productName];
        }

        function checkValuesAndUpdateButtons(productName) {
            var currentQuantity = document.querySelector(`input[name='quantity'][value='${productName}']`).value;
            var continueButton = document.getElementById('continueButton');
            var checkoutButton = document.getElementById('checkoutButton');

            // N?u giá tr? hi?n t?i khác giá tr? g?c, thì b?t nút
            if (currentQuantity !== originalValues[productName].toString()) {
                continueButton.disabled = false;
                checkoutButton.disabled = false;
            } else {
                continueButton.disabled = true;
                checkoutButton.disabled = true;
            }
        }
    </script>
<body>
    <h1>Your Cart</h1>
    <table class="cart-table">
        <thead>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
                <th>    </th>
            </tr>
        </thead>
        <tbody>
            <%
                
                Map<String,Product> product = (Map<String, Product>) session.getAttribute("Product");
              

                if (product != null && !product.isEmpty()) {
                    for (Product item : product.values()) {
            %>
            <tr>
               
                <td> 
                  
                        <form action="UpdateCart" method="post" onsubmit="checkValuesAndUpdateButtons('<%= item.getProductName() %>');">
                        <input type="hidden" name="productName" value="<%= item.getProductName() %>">
                        <input type="number" name="quantity" value="<%=  item.getQuantity() %>" min="1" 
                               onfocus="storeOriginalValue('<%= item.getProductName() %>', <%=  item.getQuantity() %>)" 
                               onblur="restoreOriginalValue('<%= item.getProductName() %>')">
                        <button type="submit">Update</button>
                    </form>
                </td>
                <td><%= item.getProductName() %></td>
                <td>$<%= String.format("%.2f", item.getProductPrice()) %></td>
                <td>$<%= String.format("%.2f", item.getProductPrice() * item.getQuantity()) %></td>
                <td>
                    <form action="RemoveProduct" method="post">
                        <input type="hidden" name="productName" value="<%= item.getProductName() %>">
                        <button type="submit">Remove</button>
                    </form>
                </td>
            </tr>
            <%
                        
                    }
                } else 
{
            %>
            <tr>
                <td colspan="5">Your cart have not product.</td>
            </tr>
            <%
                }
            %>
        </tbody>
        
    </table>
    <div class="cart-actions">
        <button class="button" onclick="window.location.href='index.html'">Continue</button>
        <% if (product != null && !product.isEmpty()) { %>
            <button class="button" onclick="window.location.href='checkOut.jsp'">Check out</button>
        <% } %>
    </div>
</body>
</html>
