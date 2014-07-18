package com.example.buttontest;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

/*
 * 1. Button by android:onClick in xml file (Buttons 1, 2)
 */

/*
 * 2. Button by listener extending the MainActivity (Buttons 3, 4)
 * 2.a Tell android you are interested in listening to a button click
 * 2.b bring your XML button inside java
 * 2.c register listener
 * 2.d what code executes when the button is clicked
 * 
 * Small memory use, but gets unwieldy with lots of buttons. Not recommended
 */

/*
 * 3. Button by extending inner class (Button 5)
 * Use when you have several buttons in a single activity
 * and want the same listener to listen to all the button clicks
 */

/*
 * 4. Button by using an Interface, anonymous inner class (Button 6)
 */

//2.a by implements OnClickListener from View class
public class MainActivity extends ActionBarActivity implements OnClickListener{
	    
	Button button;
	Button another;
	Button innerClass;
	Button interfaceButton;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //2.b instantiate third button
        button = (Button)findViewById(R.id.button3);
        //2.c add listener
        button.setOnClickListener(this);
        
        //instantiate, set listener on fourth button
        another = (Button)findViewById(R.id.button4);
        another.setOnClickListener(this);
        
        //set listener on fifth button with anonymous object
        //Or create MyButtonHandler b = new MyButtonHandler(); and pass it b
        innerClass = (Button)findViewById(R.id.button5);
        innerClass.setOnClickListener(new MyButtonHandler());
        
        //instantiate, set listener on sixth button
        another = (Button)findViewById(R.id.button6);
//      another.setOnClickListener(mine);
        //use the anonymous inner class directly as the listener argument
        another.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Log.d("APP", "Sixth button was clicked");
        	}
        });
    }
	  
	//1
	public void doSomething(View v){
		
		if(v.getId()==R.id.button1){
			Log.d("APP", "First button was clicked");
		}
		else if(v.getId()==R.id.button2){
			Log.d("APP", "Second button was clicked");
		}
		
	}
	
	//2.d click response
	@Override
	public void onClick(View v){
		if(v.getId()==R.id.button3){
			Log.d("APP", "Third button was clicked");
		}
		else if(v.getId()==R.id.button4){
			Log.d("APP", "Fourth button was clicked");
		}
	}
	
	//3
	class MyButtonHandler implements OnClickListener{
		
		public void onClick(View v){
			Log.d("APP", "Fifth button was clicked");
		}
	}
	
	/* 4. Can have multiple inner classes of an interface, 
	 * each with custom code inside the onClick method
	 * To make it anonymous, just do new OnClickListener(){ };
	 */
//	OnClickListener mine = new OnClickListener(){
//		public void onClick(View v){
//			Log.d("APP", "Sixth button was clicked");
//		}
//	}; //if not doing a listener here, can just do .method() to run the method

}
