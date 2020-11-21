<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <head>
      <title>Unsuccessful Registration</title>
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
      <h1>Registration Failed</h1>
      <s:fielderror fieldName="error" cssClass="errorMessage" />
   </body>
   <p><a href= "Register.jsp" >Try to register again</a>.</p>
</html>