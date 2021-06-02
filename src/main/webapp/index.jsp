<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html lang="en">
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Welcome To Project</h3>
		
		<c:out value="Hello" />
		<c:set var="now" value="<%=new Date()%>" />
		<fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${now}" />

	</main>
</body>
</html>
