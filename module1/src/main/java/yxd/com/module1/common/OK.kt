package yxd.com.module1.common

import com.kotlinlib.activity.AbstractActivity
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback
import okhttp3.Call
import yxd.com.module1.bean.News

class OK {

    //?kw=%E7%99%BD&site=qq.com&apikey=JHQm5BKMIG3iqzJodxYvdbdcgz7o9nDbWcNNmXJWZbjRKzfKAuIzZAVZ7ZuRhsbg

    companion object {

        const val DOMAIN_NAME = "http://api01.idataapi.cn:8000/news/qihoo"
        const val KEYWORD = "kw"

        fun getNews(kw:String, onSuccess: (data: News) -> Unit) {
            val builder = OkHttpUtils.get().url(DOMAIN_NAME)
            builder.addParams(KEYWORD, kw)
            builder.addParams("site", "qq.com")
            builder.addParams("apikey", "JHQm5BKMIG3iqzJodxYvdbdcgz7o9nDbWcNNmXJWZbjRKzfKAuIzZAVZ7ZuRhsbg")
            builder.build().execute(object : StringCallback() {
                override fun onError(call: Call?, e: Exception?, id: Int) {
                }

                override fun onResponse(response: String?, id: Int) {
                    val gson = AbstractActivity.gson
                    onSuccess.invoke(gson.fromJson(response, News::class.java))
                }
            })

        }

    }

}