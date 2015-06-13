<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello,
	<%=request.getHeader("Authorization")%>
	<%=request.getRemoteUser()%>
	<table border="1">
		<thead>
			<tr>
				<th>Catgory</th>
				<th>Information</th>
			</tr>
		</thead>
		<c:forEach items="${info}" var="suggestion">
			<tr>
				<td><c:out value="${ suggestion.category}"></c:out></td>
				<td><a
					href='<c:out value="${ suggestion.information}"></c:out>'> <c:out
							value="${ suggestion.information}"></c:out>
				</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>