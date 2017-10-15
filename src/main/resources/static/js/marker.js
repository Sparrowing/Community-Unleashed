/*
 * Set up event listeners on all markers
 * @param  markers  Array of markers to apply to
 */
function addMarkerListener(event, marker, map) {
	
	marker.addListener('click', function() {
		
		// Open info window
		setInfoWindow(marker, event.name);
		
		// Center map
		setMapCenter(marker.getPosition());
		
		// Update legend with position
		updateLegend(event);
		
	});
	
}