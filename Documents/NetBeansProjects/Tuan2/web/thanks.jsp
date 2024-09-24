<%-- 
    Document   : thanks
    Created on : Sep 9, 2024, 11:02:03 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
      <title>Survey</title>
      <link rel="stylesheet" href="style/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Thanks for joining our email list</h1>
        <p>Here is the information that you entered:</p>

        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>First Name:</label><!--
-->     <span>${user.firstName}</span><br>
        <label>Last Name:</label>
        <span>${user.lastName}</span><br><!--
-->        <label>Day of Birth: </label><!--
-->        <span>${user.birthDay}</span><br>  <!--
-->        <label> You hear about us : </label>
        <span>${user.social}</span><br>
        <label>Announcements : </label>
        <span>${user.selectOption}</span><br>
        <label>Contact :</label>
        <span>${user.contact}</span><br>
        <p>To enter another email address, click on the Back 
    button in your browser or the Return button shown 
    below.</p>

    <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
        
    </body>
</html>
