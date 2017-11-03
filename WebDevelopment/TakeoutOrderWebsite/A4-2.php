<?php session_start();?>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/css_page2.css">
	<title>Your Order</title>
</head>
<body>
	<h1>Your Order</h1>
	<div id="display">
<?php
$coffees = $_SESSION['coffee'];
$size = $_SESSION['sizes'];
$creams = $_SESSION['cream'];
$sugars = $_SESSION['sugar'];

$count_Coffees = $coffees;

while ($count_Coffees > 0){
	$count_Creams = $creams;
	$count_Sugars = $sugars;
	if ($size == "small"){
	echo "<img src='images/cup_Small.jpg'>";
	}
	else if ($size == "medium"){
	echo "<img src='images/cup_Med.jpg'>";
	}
	else if ($size == "large"){
	echo "<img src='images/cup_Large.jpg'>";
	}
	else{
	echo "<img src='images/cup.jpg'>";
	}
	if ($creams > 0 || $sugars > 0){
		echo "<img src='images/plus.jpg'>";
	}
		while ($count_Creams > 0){
			echo "<img src='images/cream.jpg'>";
			$count_Creams--;
		}
		if ($sugars > 0){
			echo "<img src='images/plus.jpg'>";
		}
			while($count_Sugars > 0){
				echo "<img src='images/sugar.jpg'>";
				$count_Sugars--;
			}
			echo nl2br("\n");
	$count_Coffees--;
}



?>
	

		
		
	</div>
	
	<div id="cost">
	<?php
		$sizeCost = 0;
		if ($size == "small"){
		$sizeCost = 1.00;
		}
		else if ($size == "medium"){
		$sizeCost = 1.25;
		}
		else if ($size == "large"){
		$sizeCost = 1.50;
		}
		else{
		$sizeCost = 1.75;
		}
		
		$coffeeWord = " ";
		if($coffees > 1){
			$coffeeWord = "coffees";
		}
		else{
			$coffeeWord = "coffee";
		}
		
		$orderWord = " ";
		if($coffees > 1){
			$orderWord = "each";
		}
		else{
			$orderWord = " ";
		}
				
		$cost_coffees = $sizeCost * $coffees;
		$cost_creams = $creams * 0.10 * $coffees;
		$cost_sugars = $sugars * 0.05 * $coffees;
		$cost_total = $cost_coffees + $cost_creams + $cost_sugars;
		$correctCost = number_format($cost_total, 2);

		echo "Your order is: ".$coffees." ".$size." ".$coffeeWord." with ".$creams." creams and ".$sugars." sugars ".$orderWord;
		echo nl2br("\n");
		echo "Your total is $".$correctCost;
	

	?>
	
	</div>
	
	

</body>
</html>