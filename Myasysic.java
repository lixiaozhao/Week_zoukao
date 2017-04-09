package bawei.com.week_zoukao1;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * 类的用途：
 * 时间:  2017/4/9  11:58
 * 姓名:  李照照
 */
public class Myasysic extends AsyncTask<String, Integer, List<Bean.ListBean>> {
   public Context context;
   public  ListView listView;

    public Myasysic(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    protected void onPostExecute(List<Bean.ListBean> listBeen) {
        super.onPostExecute(listBeen);
       Myadapter myadapter=new Myadapter(context,listBeen);
        listView.setAdapter(myadapter);
    }

    public String getData(String url) {
        try {
            URL url1 = new URL(url);
            try {
                HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                if (connection.getResponseCode() == 200) {
                    InputStream stream = connection.getInputStream();
                    StringBuilder ss = new StringBuilder();
                    BufferedReader br=new BufferedReader(new InputStreamReader(stream,"utf-8"));
                    String con="";
                    while ((con=br.readLine())!=null){
                        ss.append(con);
                    }
                    return ss.toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected List<Bean.ListBean> doInBackground(String... params) {
        String data = getData(params[0]);
         Gson gson=new Gson();
        Bean bean = gson.fromJson(data, Bean.class);
        List<Bean.ListBean> list = bean.getList();
        return list;
    }
}
