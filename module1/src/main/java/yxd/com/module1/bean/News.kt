package yxd.com.module1.bean

data class News(
    var appCode: String = "",
    var `data`: List<Data> = listOf(),
    var dataType: String = "",
    var hasNext: Boolean = false,
    var pageToken: String = "",
    var retcode: String = ""
) {
    data class Data(
        var commentCount: Any = Any(),
        var content: String = "",
        var id: String = "",
        var imageUrls: List<String>?,
        var likeCount: Any = Any(),
        var posterId: String = "",
        var posterScreenName: String = "",
        var publishDate: Int = 0,
        var publishDateStr: String = "",
        var shareCount: Any = Any(),
        var tags: Any = Any(),
        var title: String = "",
        var url: String = ""
    )
}