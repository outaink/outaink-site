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
        summary = "第一篇随笔。搭建这个个人站的初衷：像素风格像代码里的小方块——简单、明确，拼起来就能形成一个世界。这里会记录日常灵感、技术随想和生活片段。",
        tags = listOf("随笔"),
    ),
)
