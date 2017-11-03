function Clear(){
	document.getElementById("display").innerHTML = " ";
	document.getElementById("inputNum").focus();
	document.getElementById("display").style.display="none";
}

function Fahrenheit(){
	var cel = document.getElementById("inputNum").value;
	if (isNaN(cel)){
	document.getElementById("display").innerHTML = ("Numbers only!");	
	document.getElementById("display").style.display="block";
	}
	else{
	var far = (((cel*9)/5)+32);
	document.getElementById("display").innerHTML = (cel + " C is " + far.toFixed(2) + " F");
	document.getElementById("display").style.display="block";
	}
}

function Meters(){
	var feet = document.getElementById("inputNum").value;
	if (isNaN(feet)){
	document.getElementById("display").innerHTML = ("Numbers only!");	
	document.getElementById("display").style.display="block";
	}
	else{
	var meter = (feet/3.28);
	document.getElementById("display").innerHTML = (feet + " ft is " + meter.toFixed(2) + " m");
	document.getElementById("display").style.display="block";
	}
}

function Centimeters(){
	var inches = document.getElementById("inputNum").value;
	if (isNaN(inches)){
	document.getElementById("display").innerHTML = ("Numbers only!");	
	document.getElementById("display").style.display="block";
	}
	else{
	var centimeters = (inches*2.54);
	document.getElementById("display").innerHTML = (inches + " in is " + centimeters.toFixed(2) + " cm");
	document.getElementById("display").style.display="block";
	}
}

function Kilograms(){
	var pounds = document.getElementById("inputNum").value;
	if (isNaN(pounds)){
	document.getElementById("display").innerHTML = ("Numbers only!");	
	document.getElementById("display").style.display="block";
	}
	else{
	var kilo = (pounds * 0.45359237);
	document.getElementById("display").innerHTML = (pounds + " lbs is " + kilo.toFixed(2) + " kg");
	document.getElementById("display").style.display="block";
	}
}

function Celsius(){
	var far = document.getElementById("inputNum").value;
	if (isNaN(far)){
	document.getElementById("display").innerHTML = ("Numbers only!");	
	document.getElementById("display").style.display="block";
	}
	else{
	var cel = (((far-32)*5)/9);
	document.getElementById("display").innerHTML = (far + " F is " + cel.toFixed(2) + " C");
	document.getElementById("display").style.display="block";
	}
}

function Feet(){
	var meters = document.getElementById("inputNum").value;
	if (isNaN(meters)){
	document.getElementById("display").innerHTML = ("Numbers only!");	
	document.getElementById("display").style.display="block";
	}
	else{
	var feet = (meters * 3.28);
	document.getElementById("display").innerHTML = (meters + " m is " + feet.toFixed(2) + " ft");
	document.getElementById("display").style.display="block";
	}
}

function Inches(){
	var centi = document.getElementById("inputNum").value;
	if (isNaN(centi)){
	document.getElementById("display").innerHTML = ("Numbers only!");
	document.getElementById("display").style.display="block";
	}
	else{
	var inches = (centi/2.54);
	document.getElementById("display").innerHTML = (centi + " cm is " + inches.toFixed(2) + " in");
	document.getElementById("display").style.display="block";
	}
}

function Pounds(){
	var kilo = document.getElementById("inputNum").value;
	if (isNaN(kilo)){
	document.getElementById("display").innerHTML = ("Numbers only!");	
	document.getElementById("display").style.display="block";
	}
	else{
	var pounds = (kilo*2.2046226218);
	document.getElementById("display").innerHTML = (kilo + " kg is " + pounds.toFixed(2) + " lbs");
	document.getElementById("display").style.display="block";
	}
}




