package yxd.com.moduledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/test/main")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1(View view) {
        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        ARouter.getInstance().build("/test1/module1").navigation();
    }

    public void btn2(View view) {
        ARouter.getInstance().build("/test2/module2").navigation();
    }

    public void btn3(View view) {
        ARouter.getInstance().build("/test/main2").navigation();
    }
}
