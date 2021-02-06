<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/alteraEmpresa" var="linkAlteraEmpresa"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkAlteraEmpresa }" method="POST">
		Nome: <input type="text" name="empresa" value="${empresa.nome }" /> Data de criação: <input
			type="text" name="dataCriacao" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataCriacao }"/>' /> 
			<input type="text" name="id" value="${empresa.id }" hidden>
			<input type="submit" />
	</form>
</body>
</html>