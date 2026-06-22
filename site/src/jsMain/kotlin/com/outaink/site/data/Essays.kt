package com.outaink.site.data

data class Essay(
    val slug: String,
    val title: String,
    val date: String,
    val summary: String,
    val tags: List<String>,
)

val recentEssays = listOf(
    Essay(
        slug = "hello-world",
        title = "你好，世界",
        date = "2026-05-20",
        summary = "第一篇随笔，从一个像素小站开始，代码里的方块很小，拼久了，也会有世界的轮廓",
        tags = listOf("随笔"),
    ),
)
