package com.jikexueyuan.news;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

import com.jikexueyuan.news.adapter.NewsAdapter;
import com.jikexueyuan.news.model.News;
import com.jikexueyuan.news.utils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	private ListView lvNews;
	private NewsAdapter adapter;
	private List<News> newsList;

	public static  String GET_NEWS_URL = "http://apis.baidu.com/tngou/hospital/feature?id=1";

	private Handler getNewsHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			String jsonData = (String) msg.obj;
			System.out.println(jsonData);

			try {
				boolean jsonObj = new JSONObject(jsonData).optBoolean("status");
				System.out.println(jsonObj);

			} catch (JSONException e) {
				e.printStackTrace();
			}

			try {
				JSONArray jsonArray = new JSONObject(jsonData).getJSONArray("tngou");
				for (int i=0;i<jsonArray.length();i++){
					JSONObject object = jsonArray.getJSONObject(i);
					String id = object.getString("id");
					String message = object.getString("message");
					newsList.add(new News(id, message));
					System.out.println(newsList);
				}
				adapter.notifyDataSetChanged();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvNews = (ListView) findViewById(R.id.lvNews);
		newsList = new ArrayList<News>();
		adapter = new NewsAdapter(this, newsList);

		lvNews.setAdapter(adapter);
		HttpUtils.getNewsJSON(GET_NEWS_URL, getNewsHandler);
	}

}
