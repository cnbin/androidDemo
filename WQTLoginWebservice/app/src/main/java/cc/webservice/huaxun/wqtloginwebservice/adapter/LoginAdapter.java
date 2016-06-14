package cc.webservice.huaxun.wqtloginwebservice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cc.webservice.huaxun.wqtloginwebservice.R;
import cc.webservice.huaxun.wqtloginwebservice.model.LoginModel;

/**
 * Created by wuyongmin on 16/6/14.
 */
public class LoginAdapter extends BaseAdapter {

    private Context context;
    private List<LoginModel> newsList;

    public LoginAdapter(Context context, List<LoginModel> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public LoginModel getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.login_items, null);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvDesc = (TextView) convertView.findViewById(R.id.tvDesc);

        LoginModel news = newsList.get(position);
        tvTitle.setText(news.getUserName());
        tvDesc.setText(news.getTrueName());
        return convertView;
    }
}

