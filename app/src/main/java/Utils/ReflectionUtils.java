package Utils;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import neusoft.chenmo.reflectionproactivity.R;

/**
 * Created by chenmo on 15/10/15.
 */
public final class ReflectionUtils {

    public static void initView(Activity activity){
        //我要知道activity里有多少个属性
        Class clz =  activity.getClass();
        //获得activity中定义的控件属性
        Field[] fields = clz.getDeclaredFields();
        //遍历循环调用循环所有属性
        for (Field field: fields) {
           Class type = field.getType();
            //所有的控件都是view的子类  判断类型
            if(View.class.isAssignableFrom(type)){

                  //说明这个是控件属性
                //现在要获得findviewbyid的方法
                try {
                       // 因为findviewByid 不是我们写的Activity定义的
                    Method method = clz.getMethod("findViewById",new Class[]{int.class});
                     //反射的新任务 去获得更多控件id的值
                     // 先要获得控件的名字就是id的名称
                     String name = field.getName();
                     Class idCls = R.id.class;
                     Field idField =  idCls.getDeclaredField(name);
                     Object value  = idField.get("");


                   // 调用这个方法 就返回了控件对象
                    Object control =  method.invoke(activity, value);
                    //对field 进行赋值
                    field.setAccessible(true);
                    field.set(activity,control);

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
