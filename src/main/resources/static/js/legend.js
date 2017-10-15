function updateLegend(event) {
	
	$('#name-display').html(event.name);
	var date = new Date(event.startTime);
	$('#date-display').html((date.getMonth()+1) + "/" + date.getDate() + "/" + date.getFullYear());
	$('#descrip-display').html(event.description);
	
}