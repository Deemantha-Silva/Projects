<html>
<head>
<title>Assignment 3 - Deemantha Silva</title>
	<link rel="stylesheet" type="text/css" href="_css/index_css.css">
</head>

<body>
<?php
if($_SERVER['REQUEST_METHOD']=="POST")
{
	$User=$_POST['username'];
	$Pass=$_POST['password'];

	$link=mysqli_connect("localhost","root","","assignment3");
	$result=mysqli_query($link,"select * from signup where username='".$User."'");
	if($rows=mysqli_num_rows($result)>0)
	{
		echo "<script>alert('This user has already registered');</script>";
		header("location: index.php");
	}
	else
	{
		if(mysqli_query($link,"insert into signup(uname,pwd) values('".$User."','".$Pass."','".$Fname."','".$Lname."')"))
		{
			echo "<script>alert('User registered!');</script>";
			header("location: page_1.html");
		}
	}
	
?>
<img id="bg" src="_img/back.png">
<div id="header">
	<p id="title">&emsp;&emsp;&emsp;&emsp; Welcome to <br>JapanMartialEquipments.com!</p>
	<p id="title2"><i>Best Place to Buy Japanese <br>Martial Arts Equipment Online</i></p>
	</div>
	<form id="form1" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<h1 id="loginu">Username: </h1><br>
		<input type="text" id="username" required autofocus><br>
		<h1 id="loginp">Password: </h1><br>
		<input type="password" id="password" required><br>
		<h1 id="loginC">Confirm Password: </h1><br>
		<input type="password" id="passwordConfirm" required><br>
		<input type="submit" id="submit1" value="Login">
		<input type="submit" id="register1" value="Register">
	</form>
</body>
</html>