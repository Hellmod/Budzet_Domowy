<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:message code="profil.userDane"/></title>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="/WEB-INF/incl/import.app" %>

	<!--[if lt IE 9]>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>
<header>
	<%@include file="/WEB-INF/incl/menuNew.app" %>
</header>
<main>

	<section class="budget">

		<div class="container">

			<header>
				<h1><s:message code="profil.userDane" /></h1>
				<p><c:out value="${message }" /></p>
			</header>

			<div class="row">

				<div class="col-sm-8 offset-sm-2">

					<table class="table table-dark">
						<thead>
							<tr>
								<td   align="right" >
									<s:message code="register.email"/>
								</td>
								<td  align="left">
									<c:out value="${user.email }"/>
								</td>
							</tr>

							<tr>
								<td   align="right" >
									<s:message code="register.name"/>
								</td>
								<td  align="left">
									<c:out value="${user.name }"/>
								</td>
							</tr>

							<tr>
								<td   align="right" >
									<s:message code="register.lastName"/>
								</td>
								<td  align="left">
									<c:out value="${user.lastName }"/>
								</td>
							</tr>

							<tr>
								<td   align="right" >
									<s:message code="register.telephone"/>
								</td>
								<td  align="left">
									<c:out value="${user.telephone }"/>
								</td>
							</tr>

							<tr>
								<td   align="right" >
									<s:message code="register.is_fired"/>
								</td>
								<td  align="left">
									<c:choose>
										<c:when test="${register.is_fired == 1 }">
											<s:message code="word.tak"/>
										</c:when>
										<c:otherwise>
											<s:message code="word.nie"/>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>

							<tr>
								<td   align="right" >
									<s:message code="profil.rola"/>
								</td>
								<td  align="left">
									<c:choose>
										<c:when test="${user.nrRoli == 1 }">
											<s:message code="word.admin"/>
										</c:when>
										<c:otherwise>
											<s:message code="word.user"/>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</tbody>
					</table>

					<td><button type="submit" class="btn btn-primary" onclick="window.location.href='${pageContext.request.contextPath}/editprofil'"/><i class="fas fa-user-edit"></i> <s:message code="button.edycjaProfilu"/></td>

					<td><button type="submit" class="btn btn-primary" onclick="window.location.href='${pageContext.request.contextPath}/editpassword'"/><i class="fas fa-key"></i> <s:message code="button.zmianaHasla"/></td>
				</div>

			</div>

		</div>
	</section>

</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

<script src="/resources/js/bootstrap.min.js"></script>

<script>
	document.getElementById("profil").classList.add("active");
</script>
</body>
</html>
