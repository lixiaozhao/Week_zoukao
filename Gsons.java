package bawei.com.week_zoukao1;

import com.google.gson.Gson;

/**
 * 类的用途：
 * 时间:  2017/4/9  15:48
 * 姓名:  李照照
 */
public class Gsons {
    public static <T>T getAdd(String data,Class<T> beanClass){
        T t=null;
        Gson gson=new Gson();
        t= gson.fromJson(data, beanClass);
        return  t;
    }
}
