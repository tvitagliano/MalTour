<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@taglib prefix="c"
                                         uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../gestioneGenerale/header.jsp">
    <jsp:param name="pageTitle" value="Utente"/>
</jsp:include>

<section>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>Username</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Admin</th>
        </tr>
        </thead>

        <tbody>
            <tr>
                <td>${utente.id}</td>
                <td>${utente.username}</td>
                <td>${utente.nome}</td>
                <td>${utente.email}</td>
                <td>${utente.admin ? "Si" : "No"}</td>
                <td> 
                	<form action="AdminUtenti" method="post">
						<input type="hidden" name="id" value="${utente.id}">
							<c:if test="${utente != null}">
						<input type="submit" class="btn success" name="rimuovi" value="Rimuovi">
							</c:if>
					</form>
				</td>
            </tr>
        </tbody>
    </table>
</section>

<%@include file="../gestioneGenerale/footer.jsp"%>

