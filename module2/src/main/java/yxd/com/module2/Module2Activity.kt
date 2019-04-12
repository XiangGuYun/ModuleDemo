package yxd.com.module2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/test2/module2")
class Module2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module2)
    }
}
