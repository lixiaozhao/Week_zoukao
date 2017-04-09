package bawei.com.week_zoukao1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
       Myasysic myasysic=new Myasysic(MainActivity.this,list01);
        myasysic.execute(Url.url);
    }

    private void initView() {
        list01 = (ListView) findViewById(R.id.list01);
    }
}
