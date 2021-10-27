<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create shelter_finance</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Create shelter_finance</h1>
	<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
		transaction_id    :<input type="text" name="transaction_id" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		transaction_value    :<input type="text" name="transaction_value" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		transaction_type    :<input type="text" name="transaction_type" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		donor_name    :<input type="text" name="donor_name" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		person_id    :<input type="text" name="person_id" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		date    :<input type="text" name="date" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		<input type="submit" value="Create shelter_finance"/>
	</form>
  </body>
</html>
