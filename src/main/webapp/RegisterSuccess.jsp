<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registration Successful</title>
    <style>
      h1 {text-align: center;}
      p {text-align: center;}
   </style>
  </head>
  <body>
    <h1>Successful Registration</h1>

    <p>Your registration information: <s:property value="personBean" /> </p>

    <p><a href="<s:url action='index' />" >Return to home page</a>.</p>
  </body>
</html>
