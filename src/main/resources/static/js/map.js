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
		center: defaultCenter
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
	
	// Load test/default markers
	loadDefaultMarkers(map);
	
	addMarkerListeners(markers, map);
}

/*
 * Generate some markers with hard-coded coordinates
 */
function loadDefaultMarkers() {
	
	const archCoords = {
			lat: 38.6247,
			lng: -90.1848
	}

	const botanGardenCoords = {
			lat: 38.6128,
			lng: -90.2594
	}
	
	var archMarker = new google.maps.Marker({
		position: archCoords,
		map: map
	});
	
	var botanGardenMarker = new google.maps.Marker({
		position: botanGardenCoords,
		map: map
	});
	
	markers.push(archMarker);
	markers.push(botanGardenMarker);
	
}

/*
 * Set info window of marker as text
 */
function setInfoWindow(marker, text) {
	
	// Kill existing info windows
	console.log("is it killing them");
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
	console.log("killing info windows");
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
