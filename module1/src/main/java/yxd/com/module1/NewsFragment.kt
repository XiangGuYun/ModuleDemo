package yxd.com.module1

import android.os.Bundle
import android.os.Message
import com.kotlinlib.activity.Bus
import com.kotlinlib.view.KotlinFragment
import com.kotlinlib.view.recyclerview.RVUtils
import kotlinx.android.synthetic.main.frag_news.*
import org.greenrobot.eventbus.Subscribe
import yxd.com.module1.common.OK

class NewsFragment:KotlinFragment() {

    companion object {
        const val TAG = "news_tag"
        const val WHAT = 0x111
        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

    var hasFirstReq = false

    fun reqData(){
        arguments.let {
            it?.getString(TAG)?.let {
                OK.getNews(it){
                    val data = it.data
                    RVUtils(rvNews)
                            .decorate(true)
                            .rvMultiAdapter(data,
                            {
                                holder, pos ->
                                holder.text(R.id.tvTitle, data[pos].title)
                                data[pos].imageUrls?.let {
                                    when(it.size){
                                        0->{ }
                                        1->{
                                            showBitmap(getAct(), holder.iv(R.id.iv1).show(), it[0])
                                        }
                                        2->{
                                            showBitmap(getAct(), holder.iv(R.id.iv1).show(), it[0])
                                            showBitmap(getAct(), holder.iv(R.id.iv2).show(), it[1])
                                        }
                                        else->{
                                            showBitmap(getAct(), holder.iv(R.id.iv1).show(), it[0])
                                            showBitmap(getAct(), holder.iv(R.id.iv2).show(), it[1])
                                            showBitmap(getAct(), holder.iv(R.id.iv3).show(), it[2])
                                        }
                                    }
                                }

                            }, {
                                when {
                                    data[it].imageUrls!=null&&data[it].imageUrls!!.isNotEmpty() -> 1
                                    else -> 0
                                }
                            }, R.layout.item_news, R.layout.item_news3)
                }
            }
        }
    }

    override fun init() {

    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        if(!hasFirstReq){
            "请求了数据".logE("dasdaf")
            reqData()
            hasFirstReq
        }
    }

    override fun getFragLayoutId(): Int {
        return R.layout.frag_news
    }

    override fun onDestroy() {
        super.onDestroy()
    }



}