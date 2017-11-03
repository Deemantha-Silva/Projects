<?php session_start();
?>


<html>
<head>
<title>Shopping Cart</title>
	<link rel="stylesheet" type="text/css" href="_css/page_1_new_css.css">
	<script type="text/javascript" src="_scripts/page_1.js"></script>
</head>

<body onload="promoCode();">
<div id="header">
	<p id="title">JapanMartialEquipments.com<br>Product Listings</p>
	<p id="title2"><i>Elite Katanas and Samurai Armor for Great Prices!</i></p>
	</div>
	<form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		<div id="item1">
			<img id="img1"src="_img/item_1/sword1.jpg">
			<div id="leftPane"><input class ="heading" type="button" onclick="showKatana(-1)" value="&lt;"></div>
			<div id="RightPane"><input class ="heading" type="button" onclick="showKatana(1)" value="&gt;"></div>
			<span id="swordTitle">
			<span id="item1Font"><b> Tokugawa Era Blue Steel Katana</b><br>
			This Tokugawa Era Katana was forged on Mount Fuji by <br>Legendary Master Swordsmith Muramasa.<br>
			Package comes with Blue Steel Katana, Muramasa Stamped Sheath,<br>
			Purple Silk Carrying Case. Certificate of Authenticity included.<br></span>
			<i id="swordPrice">Price: <b class="priceStyle">$1399.99</b> + Tax</i></span><br>
			<span id="qty1"> Qty: <input id="katanaQty" name="qtSword" type="number" value="0" min="0" max="5"> </span>
		</div>
		<div id="tContainer">
			<img class="thumb" id="0" src="_img/item_1/sword1.jpg">
			<img class="thumb" id="1" src="_img/item_1/sword2.jpg">
			<img class="thumb" id="2" src="_img/item_1/sword3.jpg">
		</div>
		
		<div id="item2">
			<img id="img2"src="_img/item_2/armor_1.jpg">
			<div id="leftPaneA"><input class ="heading" type="button" onclick="showArmor(-1)" value="&lt;"></div>
			<div id="RightPaneA"><input class ="heading" type="button" onclick="showArmor(1)" value="&gt;"></div>
			<span id="armorTitle">
			<span id="item2Font"><b>Tokugawa Era Imperial Samurai Armor</b><br>
			This Tokugawa Era Armor was forged on in Old Kyoto<br>
			Commissioned for use under the Emperor, Ieyasu Tokugawa.<br>
			Package includes Helmet, Body Armor, Gauntlets, Leg Armor, and Boots.<br>
			Certificate of Authenticity included.<br></span>
			<i id="armorPrice">Price: <b class="priceStyle">$2999.99</b> + Tax</i></span><br>
			<span id="qty2"> Qty: <input id="armorQty" name="qArmor" type="number" value="0" min="0" max="5"></span>
		</div>	
		<div id="tContainerA">
			<img class="thumb" id="3" src="_img/item_2/armor_1thumb.jpg">
			<img class="thumb" id="4" src="_img/item_2/armor_2thumb.jpg">
			<img class="thumb" id="5" src="_img/item_2/armor_3thumb.jpg">
		</div>
		<div id="itemContainer">
		<table id="items" border="1">
			<th>Checkout Cart</th>
			<tr>
				<td id="qItems">Item Qty: 0</td>
			<tr>
				<td>
				Shipping:<br> 
				<input class="shipping" name="ship" id="shipCheck" type="radio" value="4.99" checked="checked">Standard ($4.99)<br>
				<input class="shipping" name="ship" id="shipUncheck" type="radio" value="19.99">Expedited ($19.99)
				</td>
			</tr>	
			<tr>
				<td>
				Gift Wrapping:<br>
				<input class="wrapping" name="wrap" id="giftCheck" type="radio" value="0" checked="checked">No Thanks!<br>
				<input class="wrapping" name="wrap" id="giftUncheck" type="radio" value="9.99">Yes, Please!($9.99)
				</td>			
			</tr>
			<tr>
				<td>
				Insurance:<br>
				<input class="insurance" name="ins" id="insCheck" type="radio" value="0" checked="checked">No Thanks!<br>
				<input class="insurance" name="ins" id="insUncheck" type="radio" value="1">Yes (fee of 10% of total items before tax)
				</td>			
			</tr>
			<tr>
				<td>
				Membership:<br>
				<input class="membership" name="member" id="memCheck" type="radio" value="0" checked="checked">Sign Me Up!<br>
				<input class="membership" name="member" id="memUncheck" type="radio" value="0">No Thanks!
				</td>			
			</tr>
			<tr>
				<td>
				Promo Code: <b id="pCode"></b><br>
				Enter Promo to save ($200):
				<input type = "text" name="promoEnter" id="enterPromo">
				</td>
			</tr>
			<tr>
				<td id="subtotal">Subtotal: $0</td>
			</tr>
			<tr>
				<td id="tax">Tax (13%): $0</td>
			</tr>
			<tr>
				<td id="promo">Promo: $0</td>
			</tr>
			<tr>
				<td id="total" name="tPrice">Total: $0</td>
			</tr>
			<tr>
				<td>
				<input id="reCalc" type="button" value="Recalculate" onclick="iPrices()">
				<input id="re" type="reset" value = "Reset" onclick="totalReset()">
				<input id="feedback" type="submit" value="Submit" <!--onclick="submitFeed()-->">
				</td>
			</tr>
		</table>
		</div>

	</form>
<?php
if($_SERVER['REQUEST_METHOD']=="POST")
	
{
	$User=$_SESSION['uname'];
	$QArmor=$_POST['qArmor'];
	$QSword=$_POST['qtSword'];
	
	$shipping=$_POST['ship'];
	$wrapping=$_POST['wrap'];
	$insurance=$_POST['ins'];
	$PriceArmor=0;
	$PriceSword=0;
	
	if($insurance==0){
		$insurance=1;
	}
	else{
		$insurance=1.10;
	}
	$promo=$_POST['promoEnter'];
	if(empty($promo)){
		$promo=0;
	}
	else{
		$promo=200;
	}
	
		
	$link=mysqli_connect("localhost","root","","assignment3");
	$data1=mysqli_query($link,"select address from signup where username='".$User."'");
	$row1 = mysqli_fetch_assoc($data1);
	$dataAdd = $row1['address'];
	$data2=mysqli_query($link,"select ID from signup where username='".$User."'");
	$row2 = mysqli_fetch_assoc($data2);
	$dataID = $row2['ID'];
	$ArmorID=0;
	$SwordID=0;
	
	echo $dataAdd;
	echo $dataID;
	
	if($QArmor != 0){
		$PriceArmor=((((($QArmor * 2999.99) + $shipping + $wrapping) * $insurance) - $promo)* 1.13);
		mysqli_query($link,"update products set Product_Qty = Product_Qty - ".$QArmor." where Product_ID = '1002'");
		$ArmorID=1002;
		mysqli_query($link,"insert into orders(ID, Product_ID, address, price, qty) values(".$dataID.",".$ArmorID.",'".$dataAdd."',".$PriceArmor.",".$QArmor.")");
	}
	
	if($QSword !=0){
		$PriceSword=((((($QSword * 1399.99) + $shipping + $wrapping) * $insurance) - $promo)* 1.13);
		mysqli_query($link,"update products set Product_Qty = Product_Qty - ".$QSword." where Product_ID = '1001'");
		$SwordID=1001;
		mysqli_query($link,"insert into orders(ID, Product_ID, address, price, qty) values(".$dataID.",".$SwordID.",'".$dataAdd."',".$PriceSword.",".$QSword.")");
	}
	
if($QArmor == 0 && $QSword ==0){
	echo "<script>alert('Please purchase an item to submit order');</script>";
			echo "<script>setTimeout(\"location.href = 'page_1_new.php';\",1500);</script>";	
}
else{
	echo "<script>alert('Inventory Updated, Order Received');</script>";
echo "<script>setTimeout(\"location.href = 'page_2.php';\",1500);</script>";
}

		}

?>
		
</body>
</html>