<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkNovaEmpresa"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkNovaEmpresa }" method="POST">
		Nome: <input type="text" name="empresa" /> Data de cria��o: <input
			type="text" name="dataCriacao" /> <input type="submit" />
	</form>
</body>
</html>