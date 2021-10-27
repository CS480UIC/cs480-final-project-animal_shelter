<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create medical</title>
    
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
  <h1>Create medical</h1>
	<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
		animal_id    :<input type="text" name="animal_id" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		clinic_id    :<input type="text" name="clinic_id" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		vet_id    :<input type="text" name="vet_id" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		date_of_visit    :<input type="text" name="date_of_visit" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		diagnosis    :<input type="text" name="diagnosis" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		prescription    :<input type="text" name="prescription" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		total_due    :<input type="text" name="total_due" value="${form.username }"/>
		<span style="color: red; font-weight: 900">${errors.username }</span>
		<br/>
		<input type="submit" value="Create medical"/>
	</form>
  </body>
</html>
