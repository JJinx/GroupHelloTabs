package com.example.grouphelloworld;

import java.util.Arrays;
import java.util.Hashtable;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;


public class MainActivity extends FragmentActivity {

	public static String TAG = "MainActivity";
	public static ViewPager mViewPager;
	public static ActionBar.TabListener tabListener;
	public static Hashtable<String,Class> fragments = new Hashtable();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		//Create a hashtable holding all of our 
		//fragments, which will hold small unique
		//hello world applications.
		//Our names our the key for the hashtable
		//<string><Class>
		fragments = new Hashtable();
	    fragments.put("Bobby", BobbyTab.class);
	    fragments.put("Rachel", RachelTab.class);
	    fragments.put("Robert", RobTab.class);
	    fragments.put("Ryan", RyanTab.class);	    
	    //
	    //tabNames is a local variable used to keep the list in 
	    //alphebetical order.  Hashtables auto sort, so without this tabNames
	    //array, I wouldn't be able to ensure the tabs remain in order
	    //Its not pretty... but its a helloworld
	    String[] tabNames = fragments.keySet().toArray(new String[0]);
	    Arrays.sort(tabNames);
	    //
	    //"Pager" is a viewpager control in the mainActivity
	    //mViewPager is the variable that holds that viewPager
		mViewPager = (ViewPager)findViewById(R.id.pager);
		pagerAdapter pa = new pagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(pa);		
		//
		final ActionBar actionBar = getActionBar();
		 // Specify that tabs should be displayed in the action bar.
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    // Create a tab listener that is called when the user changes tabs.
	    tabListener = new ActionBar.TabListener() {
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				tab.getText();
				mViewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
			}
	       
	    };
	    //
	    for(int i=0; i<tabNames.length;i++){
	      actionBar.addTab(
	                actionBar.newTab()
	                        .setText(tabNames[i])
	                        .setTabListener(tabListener));
	    }        
	}
	
	public class pagerAdapter extends FragmentPagerAdapter{
		public pagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			String[] tabNames = fragments.keySet().toArray(new String[0]);
		    Arrays.sort(tabNames);
		    Class c = (Class) fragments.get(tabNames[arg0]);
			Fragment f = null;
			try {
				f = (Fragment) c.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return f;
		}

		@Override
		public int getCount() {
			//Hardcoded to 4 because this is a simple
			//helloworld application with only 4 people
			//the fragment pager adapter is not recommended when 
			//you do not already know the size of your viewpager
			//FragmentStatePagerAdapter is for more complex projects
			return 4;
		}
		
	}
	
}



