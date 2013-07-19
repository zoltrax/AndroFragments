package com.androfragments;


import com.androfragments.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;


public class Main extends Activity{

	Fragment fragment;
	Button btn1, btn2, btn3;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);	
		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		Start myfragment = new Start();
		ft.add(R.id.myfragment, myfragment);
		ft.commit();
		
		btn1.setOnClickListener(btnOnClickListener);
		btn2.setOnClickListener(btnOnClickListener);
		btn3.setOnClickListener(btnOnClickListener);
		
	}
	
	Button.OnClickListener btnOnClickListener = new Button.OnClickListener(){
		@Override
		public void onClick(View v){
			
			Fragment newFragment;
			if(v == btn1){
				newFragment = new Frag1(); 
			}else if(v == btn2){
				newFragment = new Frag2();
			}else if(v == btn3){
				newFragment = new Frag3(); 
			}else{
				newFragment = new Start(); 
			}
			
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.replace(R.id.myfragment, newFragment);
			transaction.addToBackStack(null);
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			transaction.commit();
		}
	};

}
