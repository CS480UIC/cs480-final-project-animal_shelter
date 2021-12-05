<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create person</title>
    
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
  <h1>Create person</h1>
	<form action="<c:url value='/personServletCreate'/>" method="post">
		id    :<input type="text" name="id" value="${form.id }"/>
		<span style="color: red; font-weight: 900">${errors.id }</span>
		<br/>
		first_name    :<input type="text" name="first_name" value="${form.first_name }"/>
		<span style="color: red; font-weight: 900">${errors.first_name }</span>
		<br/>
		last_name    :<input type="text" name="last_name" value="${form.last_name }"/>
		<span style="color: red; font-weight: 900">${errors.last_name }</span>
		<br/>
		dob    :<input type="text" name="dob" value="${form.dob }"/>
		<span style="color: red; font-weight: 900">${errors.dob }</span>
		<br/>
		email	：<input type="text" name="email" value="${form.email }"/>
		<span style="color: red; font-weight: 900">${errors.email }</span>
		<br/>
		phone    :<input type="text" name="phone" value="${form.phone }"/>
		<span style="color: red; font-weight: 900">${errors.phone }</span>
		<br/>
		street_address    :<input type="text" name="street_address" value="${form.street_address }"/>
		<span style="color: red; font-weight: 900">${errors.street_address }</span>
		<br/>
		zip_code    :<input type="text" name="zip_code" value="${form.zip_code }"/>
		<span style="color: red; font-weight: 900">${errors.zip_code }</span>
		<br/>
		housing_status    :<input type="text" name="housing_status" value="${form.housing_status }"/>
		<span style="color: red; font-weight: 900">${errors.housing_status }</span>
		<br/>
		kids    :<input type="text" name="kids" value="${form.kids }"/>
		<span style="color: red; font-weight: 900">${errors.kids }</span>
		<br/>
		adoption_history    :<input type="text" name="adoption_history" value="${form.adoption_history }"/>
		<span style="color: red; font-weight: 900">${errors.adoption_history }</span>
		<br/>
		<input type="submit" value="Create person"/>
	</form>
  </body>
</html>
