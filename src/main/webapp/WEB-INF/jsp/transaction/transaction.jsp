<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:message code="menu.transaction"/></title>

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
				<h1><s:message code="menu.transaction" /></h1>
				<p><c:out value="${message }" /></p>
			</header>

			<div class="row">

				<div class="col-sm-10 offset-sm-1">

					<table class="table table-striped table-dark">
						<thead>
						<tr>

							<td ><s:message code="transaction.amount"/></td>
							<td ><s:message code="transaction.description"/></td>
							<td ><s:message code="transaction.category"/></td>
							<td ><s:message code="transaction.date"/></td>
						</tr>
						</thead>
						<tbody>

						<form id="planForm" action="transaction" modelAttribute="plan" enctype="multipart/form-data" method="POST" pageEncoding="UTF-8">
							<div class="form-group">
								<label for="date_string"><s:message code="plan.date"/></label>
								<input value="<c:out value="${data}" />" name="stringDate" type="month" class="form-control" aria-describedby="dateHelp" id="date_string"  value="<c:out value="${plan.date_string}" />">
							</div>
							<button type="submit"  class="btn btn-primary"> Wyszukaj <i class="fas fa-search"></i></button>

						</form>
						<c:forEach var="transaction" items="${transactionList }">
								<tr>
									<td ><c:out value="${transaction.amount }" /> zł</td>
									<td ><c:out value="${transaction.description }" /></td>
									<td ><c:out value="${transaction.category }" /></td>
									<td ><fmt:formatDate value="${transaction.date}" pattern="yyyy-MM-dd HH:mm" /></td>

									<sf:form id="${transaction.id_transaction}" action="transaction/edit" modelAttribute="transaction" enctype="multipart/form-data" method="POST">
										<sf:hidden value="${transaction.id_transaction }" path="id_transaction"/>
										<td ><button type="submit" class="btn btn-primary"/><i class="fas fa-pencil-alt"></i> <s:message code="button.edit"/></td>
									</sf:form>
									<sf:form id="${transaction.id_transaction}" action="transaction/delete" modelAttribute="transaction" enctype="multipart/form-data" method="POST">
										<sf:hidden value="${transaction.id_transaction }" path="id_transaction"/>
										<td ><button type="submit" class="btn btn-primary"/><i class="fas fa-trash-alt"></i> <s:message code="button.delete"/></td>
									</sf:form>
								</tr>
						</c:forEach>
						</tbody>
					</table>
					<p>Twoja aktualna suma pieniędzy to: <fmt:formatNumber type="number" maxFractionDigits="2" value="${amount}"/> zł</p>
					<p>Możesz jeszcze wydać: <fmt:formatNumber type="number" maxFractionDigits="2" value="${planAmount}"/> zł</p>
					<p>Twój plan <c:out value="${plan.description }" /> wynosi: <fmt:formatNumber type="number" maxFractionDigits="2" value="${plan.amount }" /> zł</p>


					<table class="table table-striped table-dark">
						<thead>
						<tr>
							<td ><s:message code="transaction.category"/></td>
                            <td ><s:message code="transaction.sumamount"/></td>
						</tr>
						</thead>
						<tbody>
                            <c:forEach var="categoryItem" items="${transactionListSortByCategory }">
                                <tr>
                                    <td ><c:out value="${categoryItem.category }" /></td>
                                    <td ><fmt:formatNumber type="number" maxFractionDigits="2" value="${categoryItem.amount}"/> zł</td>
                                </tr>
                            </c:forEach>
						</tbody>
					</table>
				</div>

			</div>

		</div>
	</section>

</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

<script src="/resources/js/bootstrap.min.js"></script>

<script>
	document.getElementById("allhour").classList.add("active");
</script>
</body>
</html>
