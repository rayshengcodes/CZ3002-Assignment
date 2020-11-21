<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login</title>
  </head>
  <body>
    <h3>Login</h3>

    <s:form action="login">
      <s:textfield name="personBean.username" label="username" />
      <s:password name="personBean.password" label="password" />
      <s:submit/>
    </s:form>
    <p><a href="<s:url action='index' />" >Return to home page</a>.</p>
  </body>
</html>