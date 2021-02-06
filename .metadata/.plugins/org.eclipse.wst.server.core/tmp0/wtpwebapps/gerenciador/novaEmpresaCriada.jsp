<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty empresa }">
Empresa ${ empresa } cadastrada com sucesso!
</c:if>

	<c:if test="${empty empresa }">
Not found 404!
</c:if>

</body>
</html>