/*
 * Set up event listeners on all markers
 * @param  markers  Array of markers to apply to
 */
function addMarkerListeners(markers, map) {
	
	// Iterate through markers
	for (var i = 0; i < markers.length; i++) {
		const marker = markers[i];
		
		// Click event listeners
		marker.addListener('click', function() {
			
			// Open info window
			setInfoWindow(marker, "this is an info window");
			
			// Center map
			setMapCenter(marker.getPosition());
			
			// Update legend with position
			console.log("1 " + marker.getPosition().latitude + " " + marker.getPosition().longitude);
			console.log("2 " + marker.getPosition().lat() + " " + marker.getPosition().lng());
			updateLegend(marker.getPosition().lat(), marker.getPosition().lng());
			
		});
	}
	
}