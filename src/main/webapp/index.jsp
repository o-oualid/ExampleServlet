<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<fieldset>
    <legend>Login</legend>
    <form action="${pageContext.request.contextPath}/FormServlet" method="post">
        Login: <input type="text" name="name"><br>
        Mot de passe: <input type="password" name="password"><br>
        <input type="submit" value="Valider">
    </form>
</fieldset>
<fieldset>
    <legend>Upload</legend>
    <form action="${pageContext.request.contextPath}/UploadFileServlet" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit">
    </form>
</fieldset>
</html>