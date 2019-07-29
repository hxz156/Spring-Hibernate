<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	Fill out the form. * means required 
	<br>
	Last Name should not be null
	<br>
	Freepass must between 0 and 10
	<br>
	PostalCode should be exactly 5 elements
	<br>
	Course code must start with "qq"
	<br> <br>
	<style>
		.error{color:red}
	</style>
</head>

<br>

<body>

	<form:form action="processForm" modelAttribute="customer">
	
		First name:<form:input path="firstName" />
		
		<br><br>
		
		Last name (*):<form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		
		<br><br>
		
		Free passes:<form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		
		<br><br>
		
		Postal Code:<form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		
		<br><br>
		
		Course Code:<form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error" />
		
		<br><br>
		
		<input type="submit" value="Cick Submit" />
		
	</form:form>

</body>

</html>








