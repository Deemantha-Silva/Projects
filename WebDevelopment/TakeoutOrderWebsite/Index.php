<?php session_start();?>
<?php
$coffees=$size=$creams=$sugars=" ";
$coffeeerr=$sizeerr=" ";
if($_SERVER["REQUEST_METHOD"]=="POST")
{
	$validations = true;
	$coffees=$_POST["numCoffees"];
	if(isset($_POST["size"])){
		$size=$_POST["size"];
	}
	else{
		$size = false;
	}
	
	$creams=$_POST["numCreams"];
	$sugars=$_POST["numSugars"];
		
	if ($coffees == 0)
	{
		$coffeeerr = "cannot be negative or zero";
		echo $sizeerr;
		$validations = false;
	}

	
	if ($size == false)
	{
		$sizeerr = "Please pick a size";
		$validations = false;
	}

	
	$_SESSION['coffee'] = $coffees;
	$_SESSION['sizes'] = $size;
	$_SESSION['cream'] = $creams;
	$_SESSION['sugar'] = $sugars;
	
	if($validations){
	header('Location: A4-2.php');
	exit();
  }
}	
?>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/css_page1.css">
	<title>Tim Horton's Order</title>
</head>
<body>



	<div id="banner">
	<img id="bannerImg" src="images/Tims.jpg">
	<img id="bannerImg2" src="images/logo.png">
	</div>
	
	<div id="info">
	<h1>Info</h1>
	<div id="prices">
	<p id="pInfo">
	<b>Coffee: </b><br>
	Small: $1.00 <br>
	Medium: $1.25<br>
	Large: $1.50<br>
	X-Large: $1.75<br>
	<br>
	<b>Extras: </b><br>
	Cream: $0.10<br>
	Sugars: $0.05<br>
	</p>
	</div>
	
	
	</div>
	
	<div id="orderTitle">
	<h1>Build Your Order</h1>
	</div>
	
	<div id="content">
		<form id="form1" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<br><br>
			<label>Number of coffees: </label>
			<input id="coffees1" name="numCoffees" type="number" min="0" value="0" autofocus>
			<span class="errors">*<?php echo $coffeeerr; ?></span>
			<br><br>
			
			<label>Size: </label>
			<input type="radio" name="size" value="small">Small
			<input type="radio" name="size" value="medium">Medium
			<input type="radio" name="size" value="large">Large
			<input type="radio" name="size" value="x-large">X-Large
			<span class="errors">*<?php echo $sizeerr; ?></span>
			<br><br>
			
			<label>Number of Creams: </label>
			<input name="numCreams" type="number" min="0" value="0">
			<br><br>
			
			<label>Number of Sugars: </label>
			<input id="sugars1" name="numSugars" type="number" min="0" value="0">
			<br><br>
			
			<input type="submit" value="Order">
			
		</form>
	</div>
</body>
</html>