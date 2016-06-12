package com.jikexueyuan.httpclientpost;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.jikexueyuan.httpclientget.R;

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
				readNet("http://10.0.2.2:8080/MyWebTest/Do",et.getText().toString());
			}
		});
		
	}

	public void readNet(String url, String in) {
		new AsyncTask<String, Void, String>() {

			@Override
			protected String doInBackground(String... arg0) {
				String urlString = arg0[0];
				
				HttpPost post  = new HttpPost(urlString);
				
				try {
					
					List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
					list.add(new BasicNameValuePair("name", arg0[1]));
					
					post.setEntity(new UrlEncodedFormEntity(list));
				} catch (UnsupportedEncodingException e1) {}
				
				
				try {
					HttpResponse response = client.execute(post);
					
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
			
			
		}.execute(url,in);
	}

}
