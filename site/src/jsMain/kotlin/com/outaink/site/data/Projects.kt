package com.outaink.site.data

data class GitHubRepo(
    val name: String,
    val description: String,
    val language: String,
    val stars: Int,
    val url: String,
    val artA: String,
    val artB: String,
    val artC: String,
)

// Update these to match the 6 pinned repos on https://github.com/outaink
// artA/B/C are pixel-art gradient colors — pick from the site palette or choose new ones
val pinnedRepos = listOf(
    GitHubRepo(
        name = "BookCrosser",
        description = "一本书从一个人手里出发，去到另一个人那里，BookCrosser 试着把这段路，放进 Android 里",
        language = "Kotlin",
        stars = 45,
        url = "https://github.com/outaink/BookCrosser",
        artA = "#ffe1a0", artB = "#c45c32", artC = "#496a49",
    ),
    GitHubRepo(
        name = "Mox",
        description = "用 Kotlin 写一个小语言，语法、运行时和设计取舍，都在一行行代码里慢慢露出形状",
        language = "Kotlin",
        stars = 32,
        url = "https://github.com/outaink/Mox",
        artA = "#ffd07a", artB = "#2f716b", artC = "#fff8e8",
    ),
    GitHubRepo(
        name = "Clox",
        description = "一台用 C 写成的栈式小机器，规则很抽象，跑起来以后却有了温度",
        language = "C",
        stars = 28,
        url = "https://github.com/outaink/Clox",
        artA = "#f6a756", artB = "#8f3928", artC = "#ffd07a",
    ),
    GitHubRepo(
        name = "Repo4",
        description = "还有一些仓库正在整理，先把位置留在这里，像书桌上一页没有写完的纸",
        language = "Kotlin",
        stars = 0,
        url = "https://github.com/outaink/",
        artA = "#c45c32", artB = "#fff0d2", artC = "#496a49",
    ),
    GitHubRepo(
        name = "Repo5",
        description = "有些项目还没想好如何介绍，等它们被重新拾起，再给它们一个合适的名字",
        language = "Python",
        stars = 0,
        url = "https://github.com/outaink/",
        artA = "#2f716b", artB = "#ffd07a", artC = "#fff8e8",
    ),
    GitHubRepo(
        name = "Repo6",
        description = "给未来的作品留一个小格子，也许是工具，也许只是某个夜晚的念头",
        language = "JavaScript",
        stars = 0,
        url = "https://github.com/outaink/",
        artA = "#8f3928", artB = "#f6a756", artC = "#ffd07a",
    ),
)
