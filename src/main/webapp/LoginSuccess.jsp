<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <head>
      <title>Successful Login</title>
      <style>
         h1 {text-align: center;}
         p {text-align: center;}
      </style>
   </head>
   
   <body>
      <h1>Successful Login</h1>
      <p>Welcome, <s:property value = "personBean"/></p>
      <p><a href="<s:url action='index' />" >Return to home page</a>.</p>
   </body>
</html>