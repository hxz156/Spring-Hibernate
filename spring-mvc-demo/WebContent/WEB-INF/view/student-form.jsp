<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName"/>
	
		<br>
	
		Last name: <form:input path="lastName"/>
	
		<br><br>
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions }"/>
			
		</form:select>
		
		<br><br>
		Favoriate Language:
		
		Java <form:radiobutton path="favoriateLanguage" value="Java" />
		C# <form:radiobutton path="favoriateLanguage" value="C#" />
		PHP <form:radiobutton path="favoriateLanguage" value="PHP" />
		Ruby <form:radiobutton path="favoriateLanguage" value="Ruby" />
		
		<br><br>
		
		Operating Systems:
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
		
		<br><br>
		
		
		<input type="submit" value="Submit" />
	</form:form>


</body>

</html>