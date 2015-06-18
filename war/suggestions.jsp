<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title }</title>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/css/bootstrap.css" rel="stylesheet" />
<link href="/resources/css/search.css" rel="stylesheet" />
<link href="/resources/css/result_table.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
	<h3 id="heading"></h3>
	<jsp:include page="search.jsp" />
	<jsp:include page="search_result.jsp"></jsp:include>
</body>
</html>