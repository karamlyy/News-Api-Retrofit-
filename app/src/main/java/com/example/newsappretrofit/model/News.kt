package com.example.newsappretrofit.model

data class News(
    var title : String,
    var link : String,
    var keywords : List<String?>?,
    var creator : List<String?>?,
    var video_url : String?,
    var description : String?,
    var content : String?,
    var pubDate : String,
    var full_description : String?,
    var image_url : String?,
    var source_id : String,
    var country : List<String>,
    var category : List<String>,
    var language : String
    )