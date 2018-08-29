<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/primer.css">
</head>
<body>
<div style="text-align: center">
    <h6 style="color: #9c2400;">${errorMsg}</h6>
    <form action="register" method="post">
        UserName: <input name="userName" type="text" /> &nbsp;
        Password: <input name="password" type="password" /> &nbsp;
        <input hidden="true" name="id" value="0003"/>
        <button type="reset">RESET</button>
        <button type="submit">REGISTER</button>&emsp;
        <a href="login" style="font-size: 10px;color: #aaaaaa">GO
            login</a>
    </form>
</div>
</body>
</html>