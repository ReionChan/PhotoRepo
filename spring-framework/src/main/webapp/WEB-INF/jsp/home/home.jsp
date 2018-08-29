<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="../css/primer.css">
</head>
<body>
<div style="text-align: left;padding: 30px;background-color: #777777;">
    <h1 style="color: #fff9ea;">Welcome ${sessionScope.user.name} ! </h1>
    <div style="text-align: right;color: #b5b5b5"><a href="/logout" style="color: #fff9ea;font-size: 15px;">Logout</a> |
        <a href="/user/${sessionScope.user.name}/del" style="color: #fff9ea;font-size: 15px;">I'm_Quit!</a>
    </div>
</div>

</body>
</html>