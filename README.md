VolumeSlider
============

*Updated for Cordova 3.0* by [@orbitaloop](https://github.com/orbitaloop)

Installation
------------

PhoneGap / Cordova iOS plugin that allows you to add a native volume slider (MPVolumeView) to your app.

Add the plugin much like any other:

### For Cordova 3.0.x:

1. To add this plugin use one of the below: 
	- `cordova plugin add https://github.com/devgeeks/VolumeSlider.git` or 
	- `phonegap local plugin add https://github.com/devgeeks/VolumeSlider.git`
2. To remove this plugin use one of the below: 
	- `cordova plugin remove org.devgeeks.volumeslider`
	- `phonegap local plugin remove org.devgeeks.volumeslider`

### NOTE: The iOS Simulator does not show MPVolumeViews. To see the slider you have to be running on an actual device.

### Example
```javascript
function onDeviceReady()
{
	var volumeSlider = window.plugins.volumeSlider;
	volumeSlider.createVolumeSlider(10,350,300,30); // origin x, origin y, width, height
	volumeSlider.showVolumeSlider();
}
```

... now since this is a native control added more or less on top of your webView, you might have to show and hide it if you navigate away from the _page_ you want the VolumeSlider on:

```javascript
volumeSlider.hideVolumeSlider();
```


## License

The MIT License

Copyright (c) 2011 Tommy-Carlos Williams (github.com/devgeeks)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
