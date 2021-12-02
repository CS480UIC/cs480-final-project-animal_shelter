<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete animal</title>
    
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
  <h1>Delete animal</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/animalServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
	<input type="hidden" name="id" value="${animal.id }"/>
	id    :<input type="text" name="id" value="${animal.id }" disabled/>
	<br/>
	name：<input type="text" name="name" value="${animal.name }" disabled/>
	<br/>
	species	：<input type="text" name="species" value="${animal.species }" disabled/>
	<br/>
	age	：<input type="text" name="age" value="${animal.age }" disabled/>
	<br/>
	physical_description	：<input type="text" name="physical_description" value="${animal.physical_description }" disabled/>
	<br/>
	microchip_id	：<input type="text" name="microchip_id" value="${animal.microchip_id }" disabled/>
	<br/>
	adoption_history	：<input type="text" name="adoption_history" value="${animal.adoption_history }" disabled/>
	<br/>
	
	<input type="submit" value="Delete animal"/>
</form>

</body>
</html>
