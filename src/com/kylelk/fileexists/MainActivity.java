package com.kylelk.fileexists;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EditText myTextBox = (EditText) findViewById(R.id.FilePath);
		myTextBox.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {}
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				EditText pathField = (EditText) findViewById(R.id.FilePath);
				
				File file = new File(""+s);
				if(file.exists() && !file.isDirectory()){
					pathField.setBackgroundResource(R.drawable.green);
				}else{
					pathField.setBackgroundResource(R.drawable.red);
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
