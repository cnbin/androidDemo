package com.jikexueyuan.httpget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AsyncTask<String, Void, Void>(){

					@Override
					protected Void doInBackground(String... params) {
						try {
							URL url = new URL(params[0]);
							URLConnection connection = url.openConnection();
							InputStream is = connection.getInputStream();
							InputStreamReader isr = new InputStreamReader(is,"utf-8");
							BufferedReader br = new BufferedReader(isr);
							String line;
							while((line = br.readLine()) != null){
								System.out.println(line);
							}
							br.close();
							isr.close();
							is.close();
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						return null;
					}
					
				}.execute("http://fanyi.youdao.com/openapi.do?keyfrom=testHttpGet&key=850021564&type=data&doctype=xml&version=1.1&q=good");
			}
		});
	}

}
