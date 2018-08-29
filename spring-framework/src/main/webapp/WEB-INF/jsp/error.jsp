<%--
  Created by IntelliJ IDEA.
  User: Reion
  Date: 18/8/18
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="../../css/primer.css"/>
    <style>
        #detail {
            margin-top: 10px;
            font-family: 'Courier New';
            text-align: left;
            border: #b5b5b5 1px solid;
            display: none;
            overflow: scroll;
        }
    </style>
    <script src="../../js/tool.js"></script>
</head>
<body>
<div style="text-align: center; background-color: #fff9ea;margin: 0px;padding: 20px;">
    <h2 style="color: #9c2400;">SORRY, SERVER INTERNAL ERROR!</h2>
</div>
<div style="margin: 30px;font-family:'Courier New';text-align: center;">
    <a id="ex" onclick="toggle('detail')">EXCEPTION: ${exception.getMessage()}</a>
    <div id="detail">
        <%
            Exception ex = (Exception) request.getAttribute("exception");
            PrintWriter printWriter = new PrintWriter(out);
            ex.printStackTrace(printWriter);
        %>
    </div>
</div>
</body>
</html>
