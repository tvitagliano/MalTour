 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
	
	<jsp:include page="../gestioneGenerale/header.jsp">
		<jsp:param name="pageTitle" value="Home"/>
	</jsp:include>
<html>
<head>

<meta charset="UTF-8">
<title>Pagamento completato</title>

</head>
<body>

<p>PAGAMENTO</p>

<%if(session.getAttribute("message")!= null){
 String message = (String) session.getAttribute("message");
	%>
	
	<%=message%>
	
	<%
	}
	%>

	<a att href="Carrello">RITORNA</a>


<%@include file="../gestioneGenerale/footer.jsp"%>

</body>
</html>
