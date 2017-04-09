package bawei.com.week_zoukao1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 类的用途：
 * 时间:  2017/4/9  15:53
 * 姓名:  李照照
 */
public class Myadapter extends BaseAdapter{

    public  Context context;
    public List<Bean.ListBean> list;
    public Myadapter(Context context, List<Bean.ListBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView==null){
            holder = new Holder();
            convertView = View.inflate(context, R.layout.item,null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.text02);
            holder.textView2 = (TextView) convertView.findViewById(R.id.text03);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();}
        holder.textView1.setText(list.get(position).getSite_name());
        holder.textView2.setText(list.get(position).getAddress());
        return convertView;
    }
    class Holder{
        TextView textView1;
        TextView textView2;
    }
}
