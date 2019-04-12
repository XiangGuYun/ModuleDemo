package yxd.com.module1

import android.os.Bundle
import com.kotlinlib.new_fragment.FragmentationPagerUtils
import com.kotlinlib.view.KotlinFragment
import kotlinx.android.synthetic.main.frag_module1.*
import me.yokeyword.fragmentation.SupportFragment

class Module1Fragment:KotlinFragment() {

    val tagList = listOf( "国际", "体育", "娱乐", "游戏", "历史", "社会")

    override fun init() {
        vp.offscreenPageLimit = tagList.size
       FragmentationPagerUtils<SupportFragment>(
               getAct(),
               vp,
               tagList.map {
                   NewsFragment.newInstance().apply { arguments = Bundle().apply { putString(NewsFragment.TAG, it) } }
               }
       ).addTabLayout(tabLayout,
               {
                   tab, index ->
                   tab.text = tagList[index]
               },
               {

               },
               {

               }, true)
    }

    override fun getFragLayoutId(): Int {
        return R.layout.frag_module1
    }

}