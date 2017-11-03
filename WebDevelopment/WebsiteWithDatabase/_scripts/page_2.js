function feedbackSubmit()
{
	alert("Thank you for you Feeback!");
	var cont = confirm("Would you like to continue shopping?");
		if(cont == true)
		{
			location.href = "page_1.html";
		}
		else
		{
			location.href = "index.html";
		}
}

function clearFeedback()
{
	document.getElementById("form1").reset();
}