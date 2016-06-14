package cc.webservice.huaxun.wqtloginwebservice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cc.webservice.huaxun.wqtloginwebservice.adapter.LoginAdapter;
import cc.webservice.huaxun.wqtloginwebservice.model.LoginModel;
import cc.webservice.huaxun.wqtloginwebservice.utils.HttpUtils;

public class MainActivity extends AppCompatActivity {

    private ListView lvNews;
    private LoginAdapter adapter;
    private List<LoginModel> newsList;

    public static  String GET_NEWS_URL = "http://192.168.1.90:10089/DWTong/Webservice/MobileService.asmx/Login?uname=admin&pass=admin";

    private Handler getNewsHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            String jsonData = (String) msg.obj;
            String substring =jsonData.substring(74,jsonData.length());
            String resultString = substring.substring(0,substring.length()-9);

            try {
                JSONArray jsonArray = new JSONArray(resultString);

                for (int i=0;i<jsonArray.length();i++){

                    JSONObject object = jsonArray.getJSONObject(i);

                    String UserName = object.getString("UserName");
                    String UserPwd = object.getString("UserPwd");
                    String TrueName = object.getString("TrueName");
                    String Serils = object.getString("Serils");
                    String Department = object.getString("Department");
                    String JiaoSe = object.getString("JiaoSe");
                    String ActiveTime = object.getString("ActiveTime");
                    String ZhiWei = object.getString("ZhiWei");
                    String ZaiGang = object.getString("ZaiGang");
                    newsList.add(new LoginModel(UserName,UserPwd,TrueName,Serils,Department,JiaoSe,ActiveTime,ZhiWei,ZaiGang));
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
        setContentView(R.layout.activity_main);

        lvNews = (ListView) findViewById(R.id.lvNews);
        newsList = new ArrayList<LoginModel>();
        adapter = new LoginAdapter(this, newsList);

        lvNews.setAdapter(adapter);
        HttpUtils.getNewsJSON(GET_NEWS_URL, getNewsHandler);
    }
}
