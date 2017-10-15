var markers = [];
var infoWindows = [];

var map;

function mapInit() {
	
	const defaultCenter = {
			lat: 38.6270,
			lng: -90.1994
	};
	
	// Create map with default center for now
	map = new google.maps.Map(document.getElementById("map"), {
		zoom: 11,
		center: defaultCenter,
		styles: [
			
			{
				"featureType": "landscape",
				"stylers": [
					{ "color": "#4D4D4D" }
				]
			},
			
			{
				"featureType": "poi",
				"stylers": [
					{ "visibility": "off" }
				]
			},
			
			{
				"featureType": "road.highway",
				"stylers": [
					{ "visibility": "off" }
				]
			},
			
		]
	});
	
	// Check if geolocation is available
	if (navigator.geolocation) {
		
		// If so, get position
		navigator.geolocation.getCurrentPosition(function(position) {
			
			pos = {
					lat: position.coords.latitude,
					lng: position.coords.longitude
			};
			
			// Set map position
			map.setCenter(pos);
		});
	}
	
	map.addListener('click', function() {
		killInfoWindows();
	});
	
	// Load event markers
	loadEvents();
}

function loadEvents() {
	$.ajax({
		url: "http://localhost:8080/events"
	}).then(function(data) {
		
		for (var i = 0; i < data.length; i++) {
			
			var pos = {
					lat: data[i].lat,
					lng: data[i].lng
			}
			
			var icon = "../images/Event_96x96.png";
			
			if (i == 0) {
				icon = "../images/Activity_96x96.png";
			}
			
			if (i == 1) {
				icon = "../images/Alert_96x96.png";
			}
			
			var marker = new google.maps.Marker({
				position: pos,
				icon: icon,
				map: map
			});
			
			makeMarker(data[i], marker);
			
		}
		
	});
}

/*
 * Set info window of marker as text
 */
function setInfoWindow(marker, text) {
	
	// Kill existing info windows
	killInfoWindows();
	
	// Open new info window
	info = new google.maps.InfoWindow();
	info.setContent(text);
	info.open(map, marker);
	infoWindows.push(info);
	
}

/*
 * Remove all active info windows
 */
function killInfoWindows() {
	for (var i = 0; i < infoWindows.length; i++) {
		infoWindows[i].close();
	}
}

/*
 * Set map center to this
 */
function setMapCenter(pos) {
	map.setCenter(pos);
}

function makeMarker(event, marker) {
	addMarkerListener(event, marker, map);
	markers.push([event, marker]);
}
