<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Student Registration Form </title>
	</head>

	<body>
		<form:form action="processForm" modelAttribute="student">

		First name: <form:input path="firstName"/>

		<br/>

		Last name: <form:input path="lastName"/>

		<br/>

		Country:

		<form:select path="country">

            <form:options items="${countries.options}"/>

		</form:select>

		<br/>

		Favorite Language:

        <form:radiobuttons path="favoriteLanguage" items="${favoriteLanguages.programmingLanguageOptions}"/>

		<br/>

		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>

		<br/>

		<input type="submit" value="Submit">

		</form:form>
	</body>

</html>