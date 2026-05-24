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
        description = "图书漂流 Android App，2024 软件工程优秀毕业设计。让「书从一个人到另一个人」变成可追踪的移动体验。",
        language = "Kotlin",
        stars = 45,
        url = "https://github.com/outaink/BookCrosser",
        artA = "#ffe1a0", artB = "#c45c32", artC = "#496a49",
    ),
    GitHubRepo(
        name = "Mox",
        description = "用 Kotlin 手写的编程语言解释器，探索语法解析、运行时流程和语言设计。",
        language = "Kotlin",
        stars = 32,
        url = "https://github.com/outaink/Mox",
        artA = "#ffd07a", artB = "#2f716b", artC = "#fff8e8",
    ),
    GitHubRepo(
        name = "Clox",
        description = "基于 C 语言的栈式虚拟机与编程语言解释器。像一台小小的像素机器，把抽象规则跑成具体结果。",
        language = "C",
        stars = 28,
        url = "https://github.com/outaink/Clox",
        artA = "#f6a756", artB = "#8f3928", artC = "#ffd07a",
    ),
    GitHubRepo(
        name = "Repo4",
        description = "[待填写] 请根据 github.com/outaink 上的 pinned 仓库更新",
        language = "Kotlin",
        stars = 0,
        url = "https://github.com/outaink/",
        artA = "#c45c32", artB = "#fff0d2", artC = "#496a49",
    ),
    GitHubRepo(
        name = "Repo5",
        description = "[待填写] 请根据 github.com/outaink 上的 pinned 仓库更新",
        language = "Python",
        stars = 0,
        url = "https://github.com/outaink/",
        artA = "#2f716b", artB = "#ffd07a", artC = "#fff8e8",
    ),
    GitHubRepo(
        name = "Repo6",
        description = "[待填写] 请根据 github.com/outaink 上的 pinned 仓库更新",
        language = "JavaScript",
        stars = 0,
        url = "https://github.com/outaink/",
        artA = "#8f3928", artB = "#f6a756", artC = "#ffd07a",
    ),
)
