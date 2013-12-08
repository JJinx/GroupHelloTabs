package com.example.grouphelloworld;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RyanTab extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
		
		View newV = inflater.inflate(R.layout.activity_ryan_tab, container,false);
		//
		//Setup simple onclick for the button
			final Button button = (Button) newV.findViewById(R.id.btnRyanDestruct);
	         button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 MediaPlayer mp = MediaPlayer.create(v.getContext(), R.raw.personfart);
	        	     mp.start();
	             }
	         });
		
		//
		
		
		return newV;
	}
	
	
}
