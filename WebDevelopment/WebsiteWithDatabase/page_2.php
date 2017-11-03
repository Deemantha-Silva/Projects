<?php session_start();
?>
<html>
<head>
<title>Feeback Submission</title>
	<link rel="stylesheet" type="text/css" href="_css/page_2_new_css.css">
	<script type="text/javascript" src="_scripts/page_2.js"></script>
</head>

<body>
<div id="header">
	<p id="title">JapanMartialEquipments.com<br> Feedback Submission</p>
	<p id="title2"><i>Best Place to Buy Japanese <br>Martial Arts Equipment Online</i></p>
	</div>
	<form id="form1" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<table id="table1" border="1">
		<tr>
			<td>
				<h2 id="col1">Personal Information</h2>
				<div id="first">
				First Name: <br>
				<input type="text" id="fName" name="firstN" required autofocus placeholder="ex: John"><br>
				Last Name: <br>
				<input type="text" id="lName" name="lastN"  required placeholder="ex: Smith"><br>
				Email: <br>
				<input type="email" id="mail" name="mailAdd" required placeholder="ex: j.smith@gmail.ca"><br>
				Phone: <br>
				<input type="tel" id="phone" name="phoneNum"  placeholder="(xxx)-xxx-xxxx">	
				</div>
			</td>
			<td>
				<h2 id="col2">Shopping Experience</h2>
				<div id="second">
				Rate our Products: <br>
				<select name="rateProd">
					<option value="Undefined">- -</option>
					<option value="1 Star">1 Star</option>
					<option value="2 Stars">2 Stars</option>
					<option value="3 Stars">3 Stars</option>
					<option value="4 Stars">4 Stars</option>
					<option value="5 Star">5 Stars</option>
				</select><br>
				Rate our Prices:<br>
				<select name="ratePrices">
					<option value="Undefined">- -</option>
					<option value="1 Star">1 Star</option>
					<option value="2 Stars">2 Stars</option>
					<option value="3 Stars">3 Stars</option>
					<option value="4 Stars">4 Stars</option>
					<option value="5 Star">5 Stars</option>
				</select><br>
				Rate our Website: <br>
				<select name="rateWeb" >
					<option value="Undefined">- -</option>
					<option value="1 Star">1 Star</option>
					<option value="2 Stars">2 Stars</option>
					<option value="3 Stars">3 Stars</option>
					<option value="4 Stars">4 Stars</option>
					<option value="5 Star">5 Stars</option>
				</select>
				</div>
			</td>
			<td>
				<h2 id="col3">Comments</h2>
				<div id="third">
				We'd love to hear from you! Please write us some feedback:<br> 
				<textarea id="comments" name="com" rows="8" cols="55"></textarea>
				</div>
			</td>
		</tr>
		</table>
		<input type="submit" id="subForm" value="Submit">
		<input type="button" id="clearForm" value="Clear" onclick="clearFeedback()">
	</form>
	
	<?php
	if($_SERVER['REQUEST_METHOD']=="POST")
{
	$User=$_SESSION['uname'];
	$first=$_POST['firstN'];
	$last=$_POST['lastN'];
	$mail=$_POST['mailAdd'];
	$phone=$_POST['phoneNum'];
	$rate1=$_POST['rateProd'];
	$rate2=$_POST['ratePrices'];
	$rate3=$_POST['rateWeb'];
	$comments=$_POST['com'];
		
	
	$link=mysqli_connect("localhost","root","","assignment3");
	
	$data=mysqli_query($link,"select ID from signup where username='".$User."'");
	$row = mysqli_fetch_assoc($data);
	$dataID = $row['ID'];
	
	mysqli_query($link,"insert into feedback(ID, first_name, last_name, email, phone, r_products, r_prices, r_web, comments) 
	values(".$dataID.",'".$first."','".$last."','".$mail."','".$phone."','".$rate1."','".$rate2."','".$rate3."','".$comments."')");
	
	 echo '<script language="javascript" type="text/javascript" >

	var cont = confirm("Thank you for you Feeback! Would you like to continue shopping?");
		if(cont == true)
		{
			location.href = "page_1_new.php";
		}
		else
		{
			location.href = "index.php";
		}

     </script>';
}
?>
	
	

</body>
<html>