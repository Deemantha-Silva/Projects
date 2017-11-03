<?php session_start();?>
<html>
<head>
<title>Assignment 3 - Deemantha Silva</title>
	<link rel="stylesheet" type="text/css" href="_css/index_new_css.css">
</head>

<body>
<img id="bg" src="_img/back.png">
<div id="header">
	<p id="title">&emsp;&emsp;&emsp;&emsp; Welcome to <br>JapanMartialEquipments.com!</p>
	<p id="title2"><i>Best Place to Buy Japanese <br>Martial Arts Equipment Online</i></p>
	</div>
	<form id="form1" onsubmit="passValid();" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<h1 id="loginu">Username: </h1><br>
		<input type="text" id="username" name="uname" required autofocus><br>
		<h1 id="loginp">Password: </h1><br>
		<input type="password" id="password" name="pass" required><br>
		<h1 id="loginC">Confirm Password: </h1><br>
		<input type="password" id="passwordConfirm" required><br>
		<h1 id="addy">Address: </h1><br>
		<input type="text" id="address" name="ads" required><br>
		<input type="submit" id="submit1" value="Login/Register">

	</form>
	
<script>
	function passValid() {
    var pass1 = document.getElementById("password").value;
    var pass2 = document.getElementById("passwordConfirm").value;
    var ok = true;
    if (pass1 != pass2) {
        alert("Passwords Do not match");
        ok = false;
    }
    else {
        alert("Passwords Match!!!");
    }
    return ok;
}


</script>	
<?php
if($_SERVER['REQUEST_METHOD']=="POST")
{
	$User=$_POST['uname'];
	$Pass=$_POST['pass'];
	$Address=$_POST['ads'];
	$link=mysqli_connect("localhost","root","","assignment3");
	$result=mysqli_query($link,"select * from signup where Username='".$User."' and Pass='".$Pass."'");
	$result2=mysqli_query($link,"select * from signup where Username='".$User."'");
	if($rows=mysqli_num_rows($result)>0)
	{
		echo "<script>alert('Logging in');</script>";
		echo "<script>setTimeout(\"location.href = 'page_1_new.php';\",1500);</script>";
	}else if($rows2=mysqli_num_rows($result2)>0)
	{
		echo "<script>alert('Error info doesn't match, try again');</script>";
		echo "<script>setTimeout(\"location.href = 'index.php';\",1500);</script>";
	}
	else
	{
		mysqli_query($link,"insert into signup(Username, Pass, address) values('".$User."','".$Pass."','".$Address."')");
			echo "<script>alert('User registered successfully');</script>";
			echo "<script>setTimeout(\"location.href = 'page_1_new.php';\",1500);</script>";	
	}
	
	$_SESSION['uname'] = $User;
	$_SESSION['pass'] = $Pass;
	exit();
}
?>
</body>
</html>