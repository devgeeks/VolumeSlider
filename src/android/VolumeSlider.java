package org.devgeeks.volumeslider;

import android.content.Context;
import android.media.AudioManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;

public class VolumeSlider extends CordovaPlugin {
    private SeekBar volumeSeekBar;

    private int cssToViewUnit(double size) {
        return (int)Math.abs(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float)size,
            cordova.getActivity().getResources().getDisplayMetrics()));
    }

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        if (action == null)
            return false;
        if (action.equals("createVolumeSlider")) {
            final int x = cssToViewUnit(args.getDouble(0));
            final int y = cssToViewUnit(args.getDouble(1));
            final int width = cssToViewUnit(args.getDouble(2));
            final int height = cssToViewUnit(args.getDouble(3));
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    createVolumeSlider(x, y, width, height);
                }
            });
            return true;
        }
        if (action.equals("showVolumeSlider")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showVolumeSlider();
                }
            });
            return true;
        }
        if (action.equals("hideVolumeSlider")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hideVolumeSlider();
                }
            });
            return true;
        }
        return false;
    }

    private void bindVolumeSeekBarToAudioManager(SeekBar volumeSeekBar, final Context context)
    {
        AudioManager audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        volumeSeekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        volumeSeekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void createVolumeSlider(int x, int y, int width, int height) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
        params.leftMargin = x;
        params.topMargin = y;

        Context context = cordova.getActivity();

        volumeSeekBar = new SeekBar(context);
        bindVolumeSeekBarToAudioManager(volumeSeekBar, context);
        hideVolumeSlider();

        RelativeLayout layout = new RelativeLayout(context);
        layout.addView(volumeSeekBar, params);
        ViewGroup container = (ViewGroup)cordova.getActivity().findViewById(android.R.id.content);
        container.addView(layout);
    }

    private void showVolumeSlider() {
        volumeSeekBar.setVisibility(View.VISIBLE);
    }

    private void hideVolumeSlider() {
        volumeSeekBar.setVisibility(View.INVISIBLE);
    }

}
