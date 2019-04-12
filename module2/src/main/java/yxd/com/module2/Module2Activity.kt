package yxd.com.module2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlinlib.activity.AbstractActivity
import com.kotlinlib.new_fragment.FragmentationUtils
import me.yokeyword.fragmentation.SupportFragment

@Route(path = "/test2/module2")
class Module2Activity : AbstractActivity() {

    override fun init(bundle: Bundle?) {
        setContentView(R.layout.activity_module2)
        FragmentationUtils<SupportFragment>(this, R.id.flContainer, ModuleFragment2())
    }

}
