var clocktext;
var sec,hr,min;
function CurrentTime() {
	today = new Date();
	year = today.getYear();  
	month = today.getMonth()+1;
	if(month <= 9){month = "0" + month;}
		day = today.getDate();
	if(day <= 9){
		day = "0" + day;
	}
	sec = today.getSeconds();
	hr = today.getHours();
	min = today.getMinutes();
	if (hr <= 9) {
		hr = "0" + hr;
	}
	if (min <= 9) {
		min = "0" + min;
	}
	if (sec <= 9) {
		sec = "0" + sec;
	}
	var clocktext = year+"/"+month+"/"+day +"  "+ hr + ":" + min + ":" + sec  ;
	clocktimer = setTimeout("CurrentTime()", 1000);
	var showtime=document.getElementById("time");
	showtime.innerText = clocktext;
	   
}