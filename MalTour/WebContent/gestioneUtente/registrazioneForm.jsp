<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<html>	
<jsp:include page="../gestioneGenerale/header.jsp">
	<jsp:param name="pageTitle" value="Registrazione utente"/>
</jsp:include>


<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
	
	/* Add padding to containers */
	.containers {
	  padding: 16px;
	}
	
	/* Full-width input fields */
	input[type=text], input[type=password] {
	  width: 100%;
	  padding: 15px;
	  margin: 5px 0 22px 0;
	  display: inline-block;
	  border: none;
	  background: #f1f1f1;
	}
	
	input[type=text]:focus, input[type=password]:focus {
	  background-color: #ddd;
	  outline: none;
	}
	
	/* Overwrite default styles of hr */
	hr {
	  border: 1px solid #f1f1f1;
	  margin-bottom: 25px;
	}
	
	/* Set a style for the submit button */
	.registerbtn {
	  background-color: #00ced1;
	  color: white;
	  padding: 16px 20px;
	  margin: 8px 0;
	  border: none;
	  cursor: pointer;
	  width: 100%;
	  opacity: 0.9;
	}
	
	.registerbtn:hover {
	  opacity: 1;
	}
	
	/* Add a blue text color to links */
	a {
	  color: dodgerblue;
	}
	
	/* Set a grey background color and center the text of the "sign in" section */
	.signin {
	  background-color: #f1f1f1;
	  text-align: center;
	}
	/* Style the content */
	.content {
	  padding: 60px;
	  height: 100%; 
	}
	
</style>
</head>
<body>

<div class="content">

	<section>
		<h1>Registrazione utente</h1>
		<h5>Riempi tutti i campi</h5>
		<form name="registrazione" action="Registrazione" method="post">
			
			<div class= "containers">
				<label>Username (almeno 6 caratteri, solo lettere e numeri, non utilizzato da altri utenti)</label>
				<input type="text" name="username" oninput="validaUsername()">
				<label>Password (almeno 8 caratteri, deve contenere: una lettera maiuscola, una minuscola, un numero)</label>
				<input type="password" name="password" oninput="validaPassword()">
				<label>Password (conferma)</label>
				<input type="password" name="passwordConferma" oninput="validaPassword()">
				<label>Nome (solo lettere e spazi)</label>
				<input type="text" name="nome" oninput="validaNome()">
				<label>Email (<b>TODO:</b> diversa da quella di utenti esistenti)</label>
				<input type="text" name="email" oninput="validaEmail()">
				<input id="registrami" class="registerbtn" type="submit" value="Registrami" disabled><span id="registramimessaggio"></span>
			</div>
			
		</form>
	</section>
	
	
	
	<script>
		var borderOk = '2px solid #080';
		var borderNo = '2px solid #f00';
		var usernameOk = false;
		var passwordOk = false;
		var nomeOk = false;
		var emailOk = false;
	
		function validaUsername() {
			var input = document.forms['registrazione']['username'];
			if (input.value.length >= 6 && input.value.match(/^[0-9a-zA-Z]+$/)) {
				// verifica se esisten un utente con lo stresso username
				var xmlHttpReq = new XMLHttpRequest();
				xmlHttpReq.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200
							&& this.responseText == '<ok/>') {
						usernameOk = true;
						input.style.border = borderOk;
					} else {
						input.style.border = borderNo;
						usernameOk = false;
					}
					cambiaStatoRegistrami();
				}
				xmlHttpReq.open("GET", "VerificaUsername?username="
						+ encodeURIComponent(input.value), true);
				xmlHttpReq.send();
			} else {
				input.style.border = borderNo;
				usernameOk = false;
				cambiaStatoRegistrami();
			}
		}
	
		function validaPassword() {
			var inputpw = document.forms['registrazione']['password'];
			var inputpwconf = document.forms['registrazione']['passwordConferma'];
			var password = inputpw.value;
			if (password.length >= 8 && password.toUpperCase() != password
					&& password.toLowerCase() != password && /[0-9]/.test(password)) {
				inputpw.style.border = borderOk;
	
				if (password == inputpwconf.value) {
					inputpwconf.style.border = borderOk;
					passwordOk = true;
				} else {
					inputpwconf.style.border = borderNo;
					passwordOk = false;
				}
			} else {
				inputpw.style.border = borderNo;
				inputpwconf.style.border = borderNo;
				passwordOk = false;
			}
			cambiaStatoRegistrami();
		}
	
		function validaNome() {
			var input = document.forms['registrazione']['nome'];
			if (input.value.trim().length > 0
					&& input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
				input.style.border = borderOk;
				nomeOk = true;
			} else {
				input.style.border = borderNo;
				nomeOk = false;
			}
			cambiaStatoRegistrami();
		}
	
		function validaEmail() {
			var input = document.forms['registrazione']['email'];
			if (input.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)) {
				input.style.border = borderOk;
				emailOk = true;
			} else {
				input.style.border = borderNo;
				emailOk = false;
			}
			cambiaStatoRegistrami();
		}
	
		function cambiaStatoRegistrami() {
			if (usernameOk && passwordOk && nomeOk && emailOk) {
				document.getElementById('registrami').disabled = false;
				document.getElementById('registramimessaggio').innerHTML = '';
			} else {
				document.getElementById('registrami').disabled = true;
				document.getElementById('registramimessaggio').innerHTML = 'Verifica che tutti i campi siano in verde.';
			}
		}
	</script>
</div>
</body>

</html>
<%@include file="../gestioneGenerale/footer.jsp"%>


