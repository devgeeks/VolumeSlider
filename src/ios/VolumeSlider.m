//
//  	VolumeSlider.m
//  	Volume Slider Cordova Plugin
//
//  	Created by Tommy-Carlos Williams on 20/07/11. Updated by Samuel Michelot on 11/05/1013
//  	Copyright 2011 Tommy-Carlos Williams. All rights reserved.
//      MIT Licensed
//

#import "VolumeSlider.h"
#import <MediaPlayer/MediaPlayer.h>

@implementation VolumeSlider

@synthesize mpVolumeViewParentView, myVolumeView, callbackId;

#ifndef __IPHONE_3_0
@synthesize webView;
#endif

-(CDVPlugin*) initWithWebView:(UIWebView*)theWebView
{
    self = (VolumeSlider*)[super initWithWebView:theWebView];
    return self;
}


#pragma mark -
#pragma mark VolumeSlider

- (void) createVolumeSlider:(CDVInvokedUrlCommand *)command
{
	NSArray* arguments = [command arguments];
    
	self.callbackId = command.callbackId;
	NSUInteger argc = [arguments count];
	
	if (argc < 3) { // at a minimum we need x origin, y origin and width...
		return;	
	}
	
	if (self.mpVolumeViewParentView != NULL) {
        	return;//already created, don't need to create it again
	}
	
	CGFloat originx,originy,width;
	CGFloat height = 30;
	
	originx = [[arguments objectAtIndex:0] floatValue];
	originy = [[arguments objectAtIndex:1] floatValue];
	width = [[arguments objectAtIndex:2] floatValue];
	if (argc > 3) {
		height = [[arguments objectAtIndex:3] floatValue];
	}
	
	CGRect viewRect = CGRectMake(
								 originx, 
								 originy, 
								 width, 
								 height
								 );
    self.mpVolumeViewParentView = [[UIView alloc] initWithFrame:viewRect];

	[self.webView.superview addSubview:mpVolumeViewParentView];
	
	mpVolumeViewParentView.backgroundColor = [UIColor clearColor];
	self.myVolumeView =
	[[MPVolumeView alloc] initWithFrame: mpVolumeViewParentView.bounds];
	[mpVolumeViewParentView addSubview: myVolumeView];
	self.myVolumeView.showsVolumeSlider = NO;
}

- (void)showVolumeSlider:(CDVInvokedUrlCommand *)command
{
	self.myVolumeView.showsVolumeSlider = YES;
	self.mpVolumeViewParentView.hidden = NO;
}

- (void)hideVolumeSlider:(CDVInvokedUrlCommand *)command
{
	self.mpVolumeViewParentView.hidden = YES;
	self.myVolumeView.showsVolumeSlider = NO;
}



@end
