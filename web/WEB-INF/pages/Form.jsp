<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sitemap Generator</title>
    <style>
        #form{
            width:248px;
            height:95px;
            padding:15px;
            margin:auto;
            position:relative;
            top:30%;
            text-align:center;
        }
    </style>
</head>
<body>
    <div id="form">
        <form action="${pageContext.request.contextPath}/form.html" method="post">
            <h4 align="center">Please enter the website address, beginning with http://</h4>
            <input type="text" name="url"><br><br>
            <input type="submit" value="Generate">
            <h3 style="color: red">${msg}</h3>
        </form>
    </div>
</body>
</html>
