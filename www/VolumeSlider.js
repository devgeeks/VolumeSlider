//
//	VolumeSlider.js
//	Volume Slider Cordova Plugin
//
//	Created by Tommy-Carlos Williams on 20/07/11. 
//  Updated by Samuel Michelot (orbitaloop) 05/11/2013
//	Copyright 2011 Tommy-Carlos Williams. All rights reserved.
//      MIT Licensed
//

var exec = require('cordova/exec');


module.exports = {

    /**
	 * Create a volume slider, and save the user's current set volume.
	 */
	createVolumeSlider : function(originx,originy,width,height) {
		exec(null, null, "VolumeSlider","createVolumeSlider", [originx, originy, width, height]);
	},
	
	/**
	 * Show the volume slider
	 */
	showVolumeSlider : function() {
		exec(null, null, "VolumeSlider","showVolumeSlider", []);
	},
	/**
	 * Hide the volume slider
	 */
	hideVolumeSlider : function() {
		exec(null, null, "VolumeSlider","hideVolumeSlider", []);
	},

    /**
     * Set the device's master volume
     */
    setVolumeSlider : function(set_volume) {
        exec(null, null, "VolumeSlider","setVolumeSlider", [set_volume]);
    },

    /**
     * Reset the volume slider to the original user volume present uon creation of this slider
     */
    resetVolumeSlider : function() {
        exec(null, null, "VolumeSlider","resetVolumeSlider", []);
    }
};
