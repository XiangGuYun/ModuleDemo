package yxd.com.moduledemo

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlinlib.activity.AbstractActivity
import com.kotlinlib.new_fragment.FragmentationTabUtils
import com.kotlinlib.other.LayoutId
import com.kotlinlib.other.StatusBarColor
import kotlinx.android.synthetic.main.activity_main.*
import me.yokeyword.fragmentation.SupportFragment
import yxd.com.module1.Module1Fragment
import yxd.com.module2.ModuleFragment2

@StatusBarColor("#66ff66")
@LayoutId(R.layout.activity_main)
@Route(path = "/test/main")
class MainActivity : AbstractActivity() {

    override fun init(bundle: Bundle?) {

        FragmentationTabUtils<SupportFragment>(
                this,
                tabLayout,
                R.id.flContainer,
                {
                    i, tab ->
                    return@FragmentationTabUtils tab.setText("Module${i+1}")
                },
                {
                    fu, frags, tab ->
                    fu.switch(tab.position)
                },
                {
                    tab ->
                },
                Module1Fragment(), ModuleFragment2()
        )

        tabLayout.setSelectedTabIndicatorHeight(0)

    }

}
