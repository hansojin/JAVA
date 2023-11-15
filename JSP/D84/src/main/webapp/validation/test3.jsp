<!DOCTYPE html>
<html>
<body>
	<form name="myForm">
		password: <input type="password" name="pw" id="pw" oninput="checkPassword()"><br>
		checkPW : <input type="password" name="pw2" id="pw2" oninput="checkPassword()"><br>
		<input type="submit" value="Submit" id="submit" disabled="disabled">
	</form>
	<script>
		function checkPassword() {
			var one = document.getElementById("pw").value;
			var two = document.getElementById("pw2").value;
			var btn = document.getElementById("submit");

			if (one === two && one.length > 0) {
				btn.removeAttribute('disabled');
			} else {
				btn.setAttribute('disabled', 'disabled');
			}
		}
	</script>
</body>
</html>
