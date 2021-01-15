<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <%
        /*免登录情况*/
        String username = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("usernameCookie")){
                    username = cookie.getValue();
                }
                if(cookie.getName().equals("passwordCookie")){
                    password = cookie.getValue();
                }
            }
        }

        request.setCharacterEncoding("utf-8");

        if(username!=null&&password!=null){
            request.getRequestDispatcher("user?username="+username+"&password="+password).forward(request,response);
        }
    %>


<form id="loginForm" action="user" method="post">
    <table border="1px" cellpadding="10px" cellspacing="0">
        <tr>
            <th colspan="2">登录界面</th>
        </tr>
        <tr>
            <td>姓 名</td>
            <td><input type="text" name="username" placeholder="请输入姓名" id="username" /></td>
        </tr>
        <tr>
            <td>密 码</td>
            <td><input type="password" name="password" id="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <select name="select">
                    <option value="0">一直需要验证登录</option>
                    <option value="7">7天内免登录</option>
                    <option value="15">15天内免登录</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录1"/>
                <input type="button" value="登录2"/>
            </td>
        </tr>
    </table>
</form>
</body>
<script src="js/jquery-3.1.1.js"></script>
<script>
    $(":button").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        if(username!="" && password!=""){
            $("#loginForm").submit();
        }
    });
    
</script>
</html>
