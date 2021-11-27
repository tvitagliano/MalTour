<%@page import="GestioneServizi.Servizio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page
	import="java.util.List,GestioneServizi.Servizio,GestioneUtente.Utente"%>
<html>
<head>
<%
		List <Servizio> servizi =  (List <Servizio>) request.getAttribute("servizi");
 		Utente utenti = (Utente) request.getAttribute("utente");
	%>

<title>MALTOUR - ${param.pageTitle}</title>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--<link href="bare.min.css" rel="stylesheet"> http://www.barecss.com -->

<script src="ricerca.js"></script>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

.bg-img {
	/* The image used */
	background-image: url("img/home7.jpg");
	min-height: 650px;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	/* Needed to position the navbar */
	position: relative;
}

/* Position the navbar container inside the image */
.container {
	float: right;
	position: right;
	margin: 60px;
	width: auto;
}

.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

/* The navbar */
.topnav {
	overflow: hidden;
	background-color: none;
	position: right;
}

/* Navbar links */
.topnav a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
	border-bottom: 3px solid transparent;
}

.topnav a:hover {
	border-bottom: 3px solid red;
}

.topnav a.active {
	border-bottom: 3px solid red;
}

.topnav-left {
	float: left;
	position: left;
	margin: 20px;
	width: auto;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 17px;
	border: none;
	outline: none;
	color: black;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: none;
	min-width: 200px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 16px 20px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: none;
	color: black;
}

.topnav a:hover, .dropdown:hover .dropbtn {
	background-color: none;
	color: black;
}

.dropdown:hover .dropdown-content {
	display: block;
}

@media screen and (max-width: 600px) {
	.topnav a:not (:first-child ), .dropdown .dropbtn {
		display: none;
	}
	.topnav a.icon {
		float: right;
		display: block;
	}
}

@media screen and (max-width: 600px) {
	.topnav.responsive {
		position: relative;
	}
	.topnav.responsive .icon {
		position: absolute;
		right: 0;
		top: 0;
	}
	.topnav.responsive a {
		float: none;
		display: block;
		text-align: left;
	}
	.topnav.responsive .dropdown {
		float: none;
	}
	.topnav.responsive .dropdown-content {
		position: relative;
	}
	.topnav.responsive .dropdown .dropbtn {
		display: block;
		width: 100%;
		text-align: left;
	}
}

#s {
	width: 500px;
	height: 40px;
	padding: 0 28px;
	-moz-border-radius: 14px;
	-webkit-border-radius: 14px;
	border-radius: 14px;
	-moz-box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.75) inset;
	-webkit-box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.75) inset;
	box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.75) inset;
}

/* Add styles to the form container */
.form-container {
	max-width: 300px;
	padding: 20px;
	background-color: none;
}
/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
	width: 100%;
	padding: 10px;
	margin: 3px 0 15px 0;
	border: none;
	background: #f1f1f1;
}
/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus
	{
	background-color: #ddd;
	outline: none;
}
/* Set a style for the submit/login button */
.form-container .btn {
	background-color: #00ced1;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}

.btns {
	border: 2px solid black;
	background-color: white;
	color: black;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
}

/* Green */
.success {
	border-color: #04AA6D;
	color: green;
}
</style>

</head>

<body>
	<div class="bg-img">
		<div class="container">

			<div class="centered">
				<br>
				<br>
				<br>
				<form action="Ricerca" method="post">
					<input type="text" id="s" name="q" list="ricerca-datalist"
						placeholder="Ricerca qui.." onkeyup="ricerca(this.value)"
						value="<c:out value="${param.q}" />">
					<button type="submit">
						<img id="cerca" src="img/cerca.png" width="25" height="25">
					</button>
					<datalist id="ricerca-datalist"></datalist>
				</form>

			</div>

			<div class="topnav">

				<div class="dropdown">
					<button class="dropbtn">
						HOME <i class="fa fa-caret-down"></i>
					</button>
					<div class="dropdown-content">
						<a href="ChiSiamo">Chi siamo</a> <a href="About">Contatti</a> <a
							href="Sedi">Le agenzie</a>
					</div>
				</div>

				<div class="dropdown">
					<button class="dropbtn">
						SERVIZI <i class="fa fa-caret-down"></i>
					</button>
					<div class="dropdown-content">
						<% 
					for(int i = 0; i< servizi.size() ; i++){
						Servizio servizio =  servizi.get(i);
				%>
						<a href="Servizio?id=<%=servizio.getId() %>"> <%= servizio.getNome() %></a>
						<%
					}
				%>
					</div>
				</div>

				<div class="dropdown">
					<button class="dropbtn">
						CONSULENZA <i class="fa fa-caret-down"></i>
					</button>
					<div class="dropdown-content">
						<a href="#">Consulenza online</a> <a href="#">Regala un
							viaggio</a>
					</div>
				</div>

				<div class="dropdown">
					<button class="dropbtn">
						<img id="login" src="img/login.png" width="30" height="20">
						<i class="fa fa-caret-down"></i>
					</button>
					<div class="dropdown-content">
						<c:choose>
							<c:when test="${utente == null}">
								<menu>
									<form action="Login" method="post" class="form-container">
										<input type="text" name="username" placeholder="Username"><br>
										<input type="password" name="password" placeholder="Password"><br>
										<input type="submit" class="btns success" value="Login">
									</form>
									<a href="RegistrazioneForm">REGISTATI</a>
								</menu>
							</c:when>

							<c:otherwise>
								<a>${utente.admin ? 'Admin' : 'Account'}</a>
								<menu>
									<c:if test="${utente.admin}">
										<a href="AdminServizio">Aggiungi Servizio</a>
										<a href="AdminOfferta">Aggiungi Offerta</a>
										<a href="AdminUtenti">Utenti Registrati</a>
										<a href="Profilo?id=<c:out value="${utente.id}"/>">Profilo</a>
										<a
											href="MieiOrdini?id=<c:out value="${utente.id}"/>&username=<c:out value="${utente.username}>"/>">I
											Miei Ordini</a>
									</c:if>
									<h3>
										Benvenut* <br> ${utente.nome}
									</h3>
									<form action="Logout">
										<input type="submit" class="btns success" value="Logout">
									</form>
								</menu>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<!-- carrello -->
				<a href="Carrello"><img src="img/carrello.png" width="30"
					height="20"></a>


				<!-- contatti -->
				<a href="About"><img id="contatti" src="img/contatti.png"
					width="30" height="20"></a>

			</div>
		</div>

		<div class="topnav-left">
			<a href="."><img id="logo" src="img/logo1.png" width="300"
				height="140"></a>
		</div>

	</div>
</body>
</html>
