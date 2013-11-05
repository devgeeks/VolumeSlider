//
//	VolumeSlider.js
//	Volume Slider Cordova Plugin
//
//	Created by Tommy-Carlos Williams on 20/07/11. update by Samuel Michelot (orbitaloop) 11/05/2013
//	Copyright 2011 Tommy-Carlos Williams. All rights reserved.
//      MIT Licensed
//
var VolumeSlider = function () {

};

VolumeSlider.prototype = {

    clear: function () {
        cordova.exec(null, null, 'Badge', 'setBadge', [0]);
    },

    set: function (badge) {
        cordova.exec(null, null, 'Badge', 'setBadge', [parseInt(badge) || 0]);
    }

	/**
	 * Create a volume slider.
	 */
	createVolumeSlider : function(originx,originy,width,height) {
		cordova.exec(null, null, "VolumeSlider","createVolumeSlider", [originx, originy, width, height]);
	};
	
	/**
	 * Show the volume slider
	 */
	showVolumeSlider : function() {
		cordova.exec(null, null, "VolumeSlider","showVolumeSlider", []);
	};
	/**
	 * Hide the volume slider
	 */
	hideVolumeSlider : function() {
		cordova.exec(null, null, "VolumeSlider","hideVolumeSlider", []);
	};
};

var plugin = new VolumeSlider();

module.exports = plugin;