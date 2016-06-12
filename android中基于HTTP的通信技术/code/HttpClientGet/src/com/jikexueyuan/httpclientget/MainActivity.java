package com.jikexueyuan.httpclientget;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	
	private EditText et;
	private TextView text;
	
	HttpClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		client = new DefaultHttpClient();
		
		et = (EditText) findViewById(R.id.editText1);
		text = (TextView) findViewById(R.id.textView1);
		
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				readNet("http://10.0.2.2:8080/MyWebTest/Do?name="+et.getText());
			}
		});
		
	}

	public void readNet(String url) {
		new AsyncTask<String, Void, String>() {

			@Override
			protected String doInBackground(String... arg0) {
				String urlString = arg0[0];
				HttpGet get = new HttpGet(urlString);
				
				try {
					HttpResponse response = client.execute(get);
					
					String value = EntityUtils.toString(response.getEntity());
					
//					System.out.println(value);
					return value;
					
					
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return null;
			}

			@Override
			protected void onPostExecute(String result) {
				text.setText(result);
			}
			
			
		}.execute(url);
	}

}
