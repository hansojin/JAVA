<!DOCTYPE html>
<html>
<body>
	<form name="myForm" action="test2Check.jsp" onsubmit="return myFunction()" method="post">
		Name: <input type="text" name="name"> 
		<input type="submit" value="Submit">
	</form>
	<script>
		function myFunction() {
			var x = document.forms["myForm"]["name"].value;
			if (x == "") {
				alert("Name must be filled out");
				return false;
			}
		}
	</script>
</body>
</html>