<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

	<title>Customer Confirmation</title>

</head>


<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

The free pass is: ${customer.freePasses}

<br><br>

The postal Code is: ${customer.postalCode}

<br><br>

The Course Code is: ${customer.courseCode}

</body>


</html>








