package neusoft.chenmo.reflectionproactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Utils.ReflectionUtils;

public class MainActivity extends AppCompatActivity {

    private TextView tv_one;
    private TextView tv_two;
    private TextView tv_three;
    private Button  btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //不需要写一大堆findviewById
        ReflectionUtils.initView(this);

    }

    public void show(View view){
        Toast.makeText(this,tv_two.getText(),Toast.LENGTH_LONG).show();


    }


}
