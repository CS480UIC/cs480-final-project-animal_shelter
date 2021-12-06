<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Person</title>
    
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
  <h1>Update Person</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	id    :<input type="text" name="username" value="${person.id }" disabled/>
	<br/>
	first_name：<input type="text" name="first_name" value="${person.first_name }" disabled/>
	<br/>
	last_name	：<input type="text" name="last_name" value="${person.last_name }" disabled/>
	<br/>
	dob	：<input type="text" name="dob" value="${person.dob }" disabled/>
	<br/>
	email	：<input type="text" name="email" value="${person.email }" disabled/>
	<br/>
	phone	：<input type="text" name="phone" value="${person.phone }" disabled/>
	<br/>
	street_address	：<input type="text" name="street_address" value="${person.street_address }" disabled/>
	<br/>
	zip_code	：<input type="text" name="zip_code" value="${person.zip_code }" disabled/>
	<br/>
	housing_status	：<input type="text" name="housing_status" value="${person.housing_status }" disabled/>
	<br/>
	kids	：<input type="text" name="kids" value="${person.kids }" disabled/>
	<br/>
	adoption_history	：<input type="text" name="adoption_status" value="${person.adoption_history }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/personServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="id" value="${person.id }"/>
	first_name：<input type="text" name="first_name" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	last_name：<input type="text" name="last_name" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	dob：<input type="text" name="dob" value="${form.dob }"/>
	<span style="color: red; font-weight: 900">${errors.dob }</span>
	<br/>
	email	：<input type="text" name="email" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	phone：<input type="text" name="phone" value="${form.phone }"/>
	<span style="color: red; font-weight: 900">${errors.phone }</span>
	<br/>
	street_address：<input type="text" name="street_address" value="${form.street_address }"/>
	<span style="color: red; font-weight: 900">${errors.street_address }</span>
	<br/>
	zip_code：<input type="text" name="zip_code" value="${form.zip_code }"/>
	<span style="color: red; font-weight: 900">${errors.zip_code }</span>
	<br/>
	housing_status：<input type="text" name="housing_status" value="${form.housing_status }"/>
	<span style="color: red; font-weight: 900">${errors.housing_status }</span>
	<br/>
	kids：<input type="text" name="kids" value="${form.kids }"/>
	<span style="color: red; font-weight: 900">${errors.kids }</span>
	<br/>
	adoption_history：<input type="text" name="adoption_history" value="${form.adoption_history }"/>
	<span style="color: red; font-weight: 900">${errors.adoption_history }</span>
	<br/>
	<input type="submit" value="Update Person"/>
</form>

</body>
</html>
