package com.example.grouphelloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BobbyTab extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View mainView = inflater.inflate(R.layout.activity_bobby_tab, container,false);
		final Button helloButton = (Button)mainView.findViewById(R.id.helloButton);
		final TextView greetText = (TextView)mainView.findViewById(R.id.greetTextView);
		
		
		//
		View.OnClickListener clickHandler = new View.OnClickListener() 
		{
			int greeting = R.string.engGreet;
			public void onClick(View clicked)
			{
				switch(clicked.getId())
				{
				case R.id.englishRB:
				{
					greetText.setText("");
					greeting = R.string.engGreet;
					helloButton.setText(R.string.engHWStr);
					break;
				}
				case R.id.spanishRB:
				{
					greetText.setText("");
					greeting = R.string.spaGreet;
					helloButton.setText(R.string.spaHWStr);
					break;
				}
				case R.id.frenchRB:
				{
					greetText.setText("");
					greeting = R.string.fraGreet;
					helloButton.setText(R.string.frHWStr);
					break;
				}
				case R.id.italianRB:
				{
					greetText.setText("");
					greeting = R.string.itaGreet;
					helloButton.setText(R.string.itaHWStr);
					break;
				}
				case R.id.portugueseRB:
				{
					greetText.setText("");
					greeting = R.string.portGreet;
					helloButton.setText(R.string.portHWStr);
					break;
				}
				case R.id.germanRB:
				{
					greetText.setText("");
					greeting = R.string.gerGreet;
					helloButton.setText(R.string.gerHWStr);
					break;
				}
				case R.id.helloButton:
				{
					greetText.setText(greeting);
					break;
				}
				}
			}
		};
		mainView.findViewById(R.id.englishRB).setOnClickListener(clickHandler);
		mainView.findViewById(R.id.spanishRB).setOnClickListener(clickHandler);
		mainView.findViewById(R.id.frenchRB).setOnClickListener(clickHandler);
		mainView.findViewById(R.id.portugueseRB).setOnClickListener(clickHandler);
		mainView.findViewById(R.id.italianRB).setOnClickListener(clickHandler);
		mainView.findViewById(R.id.germanRB).setOnClickListener(clickHandler);
		helloButton.setOnClickListener(clickHandler);
		
		return mainView;
	}
}
