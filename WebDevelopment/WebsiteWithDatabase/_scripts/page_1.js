var img = ["_img/item_1/sword1.jpg" , "_img/item_1/sword2.jpg" , "_img/item_1/sword3.jpg" , "_img/item_2/armor_1.jpg" , "_img/item_2/armor_2.jpg" , "_img/item_2/armor_3.jpg"];
var start = 0;
var end = 2;

var begin = 3;
var finish = 5;	

var count = 0;


function promoCode()
{
	var promo = ""; 
	var available = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghiklmnopqrstuvwxyz0123456789";
	
	for (var i=0; i<7 ; i++){
		promo += available.charAt(Math.floor(Math.random() * available.length));
	}
	document.getElementById("pCode").innerHTML = promo;
	
}

function iPrices() 
{
	var swordQTY = parseInt(document.getElementById("katanaQty").value);
	var armorQTY = parseInt(document.getElementById("armorQty").value);
	var price = 1399.99 * swordQTY;
	var priceArmor = 2999.99 * armorQTY;
	var shipping = document.getElementsByName("ship");
	var wrapping = document.getElementsByName("wrap");
	var insurance = document.getElementsByName("ins");
	var subtotal = 0;
	var tax = 0;
	var total = 0;
	var insuranceSub = 0;
	var promoPrice = 0;
	
	if(swordQTY == 0 && armorQTY == 0)
	{
		document.getElementById("qItems").innerHTML = ("Item Qty: 0"); 
		document.getElementById("subtotal").innerHTML = ("Subtotal: $0");
		document.getElementById("tax").innerHTML = ("Tax (13%): $0");
		document.getElementById("total").innerHTML = ("Total: $0");
		
	}
	else{
		
	document.getElementById("qItems").innerHTML = ("Item Qty: " 
	+ (swordQTY + armorQTY)); 
	
	for(var i=0; i< shipping.length; i++){
		if(shipping[i].checked)
			var ship = parseFloat(shipping[i].value);
	}
	
	for(var i=0; i< wrapping.length; i++){
		if(wrapping[i].checked)
			var wrap = parseFloat(wrapping[i].value);
	}
	
	for(var i=0; i< insurance.length; i++){
		if(insurance[i].checked){
			var insur = parseFloat(insurance[i].value);
			if (insur >0 ){
				insuranceSub = (price + priceArmor + ship + wrap)*0.10;
			}
		}
	}
	

	var promoUser = document.getElementById("enterPromo").value;
	
	if(promoUser == "")
	{
		document.getElementById("promo").innerHTML = ("Promo: $0");
	}
	else
	{
		promoPrice = 200;
		document.getElementById("promo").style.color = "red";
		document.getElementById("promo").innerHTML = ("Promo: $200");
	}
		
	var subT = (price + priceArmor + ship + wrap + insuranceSub);
	subtotal = document.getElementById("subtotal").innerHTML = ("Subtotal: $" + 
	subT.toFixed(2));
	
	var taxT = (subT * 0.13);
	tax = document.getElementById("tax").innerHTML = ("Tax (13%): $ " + taxT.toFixed(2));
	
	var totalT = (subT + taxT - promoPrice);
	var total = document.getElementById("total").innerHTML = ("Total: $ " + totalT.toFixed(2));
	count ++;
}
}

function totalReset()
{
	document.getElementById("shipCheck").checked = true;
	document.getElementById("giftCheck").checked = true;
	document.getElementById("insCheck").checked = true;
	document.getElementById("memCheck").checked = true;
	document.getElementById("qItems").innerHTML = ("Item Qty: 0"); 
	document.getElementById("subtotal").innerHTML = ("Subtotal: $0");
	document.getElementById("tax").innerHTML = ("Tax (13%): $0");
	document.getElementById("promo").style.color = "black";
	document.getElementById("promo").innerHTML = ("Promo: $0");
	document.getElementById("total").innerHTML = ("Total: $0");
	promoPrice = 0;
	count = 0;
	promoCode();
}

function submitFeed()
{
	if (count > 0){
		if(document.getElementById("memCheck").checked == true){
			alert("Thanks for shopping with Japan Martial Equipments. We see that you signed up for our Membership! We'd love to hear some feedback from you!");
			location.href = "page_2.html";
		}
		else{
			alert("Thanks for shopping with Japan Martial Equipments. We'd love to hear some feedback from you!");
			location.href = "page_2.html";
		}
	}
	else
		alert("Your cart is empty! Please select items for purchase");
	
	}
	
	

function showKatana(num)
{
	document.getElementById(start).style.border="0px";
	start = start + num;
	if(start < 0){
		start = end;
	}
	if (start > end){
		start = 0;
	}
	document.getElementById("img1").src=img[start];
	document.getElementById(start).style.border="1px solid red";
}

function showArmor(x)
{
	document.getElementById(begin).style.border="0px";
	begin = begin + x;
	if(begin < 3){
		begin = finish;
	}
	if (begin > finish){
		begin = 3;
	}
	document.getElementById("img2").src=img[begin];
	document.getElementById(begin).style.border="1px solid red";
}

















