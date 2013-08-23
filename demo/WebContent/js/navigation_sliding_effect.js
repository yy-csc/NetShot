$(document).ready(function() {
	slide("#sliding-navigation", 0, 0, 0, 0);
});

function slide(navigation_id, pad_out, pad_in, time, multiplier) {
	// creates the target paths
	var list_elements = navigation_id + " li.sliding-element";
	var link_elements = list_elements + " a";

	// initiates the timer used for the sliding animation
	var timer = 0;

	// creates the slide animation for all list elements
	$(list_elements).each(function(i) {
		// margin left = - ([width of element] + [total vertical padding of
		// element])
		// $(this).css("margin-left","-180px");
		$(this).css("margin-left", "0px");

		// updates timer
		// timer = (timer*multiplier + time);
		// $(this).animate({ marginLeft: "0" }, timer);
		// $(this).animate({ marginLeft: "0" }, timer);
		// $(this).animate({ marginLeft: "0" }, timer);
	});

	// creates the hover-slide effect for all link elements
	$(link_elements).each(function(i) {
		$(this).mouseover(function() {
			$(this).css("backgroundColor", "#C67171");
		});
		$(this).mouseout(function() {
			$(this).css("backgroundColor", "#eeeeee");
		});
		$(this).click(function() {
			$(this).css("backgroundColor", "#C67171");
		});
	});
}