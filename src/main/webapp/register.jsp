<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
  </head>
  <body>
    <h3>Register by completing this form.</h3>

    <s:form action="register">
      <s:textfield name="personBean.username" label="username" />
      <s:textfield name="personBean.name" label="name" />
      <s:textfield name="personBean.password"  label ="password"/>  
      <s:submit/>
    </s:form>	
  </body>
</html>