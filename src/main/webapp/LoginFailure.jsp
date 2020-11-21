<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <head>
      <title>Unsuccessful Login</title>
      <style>
         h1 {text-align: center;}
         p {text-align: center;}
         .errorMessage {
            text-align: center;
            list-style: none;
         }
      </style>
   </head>
   
   <body>
      <h1>Login Failed</h1>
      <s:fielderror fieldName="error" cssClass="errorMessage" />
      <p>Wrong user name or password provided.</p>
   </body>
   <p><a href= "Login.jsp" >Try to Login again</a>.</p>
</html>