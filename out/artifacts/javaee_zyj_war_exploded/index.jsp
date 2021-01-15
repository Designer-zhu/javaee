<%--
  Created by IntelliJ IDEA.
  User: designal
  Date: 2021/1/14
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  hello world <br/>
  <a href="first">访问FirstServlet</a>
  <form action="first" method="get">
    <table border="1px" cellpadding="10px" cellspacing="0px">
      <tr>
        <th colspan="2">登录界面</th>
      </tr>
      <tr>
        <td align="right">用户名：</td>
        <td><input type="text" name="username"/></td>
      </tr>
      <tr>
        <td align="right">密码：</td>
        <td><input type="password" name="password"/></td>
      </tr>
      <tr>
        <td>爱 好</td>
        <td>
          <input type="checkbox" name="hobby" value="游戏" />游戏
          <input type="checkbox" name="hobby" value="编程" />编程
          <input type="checkbox" name="hobby" value="音乐" />音乐
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" value="注册"/>
        </td>
      </tr>

    </table>
  </form>
  </body>
</html>
