package yxd.com.module1

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlinlib.activity.AbstractActivity

@Route(path = "/test1/module1")
class Module1Activity : AbstractActivity() {

    override fun init(bundle: Bundle?) {
        setContentView(R.layout.activity_module1)
    }

}
