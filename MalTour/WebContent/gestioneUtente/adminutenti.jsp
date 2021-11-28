
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../gestioneGenerale/header.jsp">
	<jsp:param name="pageTitle" value="Utenti"/>
</jsp:include>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
	table {
	  border-collapse: collapse;
	  border-spacing: 0;
	  width: 100%;
	  border: 1px solid #ddd;
	}
	
	th, td {
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even){background-color: #f2f2f2}
	
	/* Style the content */
	.content {
	  padding: 60px;
	}
	
	.btn {
	  border: 2px solid black;
	  background-color: white;
	  color: black;
	  padding: 14px 28px;
	  font-size: 16px;
	  cursor: pointer;
	}
	
	/* Green */
	.success {
	  border-color: #00ced1;
	  color: #00ced1;
	}
	
	.success:hover {
	  background-color: #00ced1;
	  color: white;
	}

	
	</style>
</head>
<body>


<div class="content">
	<h2>Utenti registrati</h2>
	<div style="overflow-x:auto;">
	  	<table>
	    	<tr>
		      	<th>id</th>
				<th>Username</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Admin</th>
				<th>Ordini</th>
				<th>Azioni</th>
	   		</tr>
	    
	    	<c:forEach items="${utenti}" var="utente">
				<tr>
					<td>${utente.id}</td>
					<td>${utente.username}</td>
					<td>${utente.nome}</td>
					<td>${utente.email}</td>
					<td>${utente.admin ? "Si" : "No"}</td>
					<td><a href="Carrello" btn primary>...</a></td>
					<td>
						<form action="AdminUtenti" method="post">
							<input type="hidden" name="id" value="${utente.id}">
							<c:if test="${utente != null}">
								<input type="submit" class="btn success" name="rimuovi" value="Rimuovi">
							</c:if>
						</form>
					</td>
				</tr>
			</c:forEach>
	    
	    </table>
	</div>
</div>

</body>
</html>


	
<%@include file="../gestioneGenerale/footer.jsp"%>




