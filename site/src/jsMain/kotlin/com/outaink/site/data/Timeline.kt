package com.outaink.site.data

enum class TimelineType { EDUCATION, WORK, ACHIEVEMENT }

data class TimelineEntry(
    val dateRange: String,
    val title: String,
    val institution: String,
    val location: String,
    val description: String,
    val type: TimelineType,
    val highlight: Boolean = false,
)

val timelineEntries = listOf(
    TimelineEntry(
        dateRange = "2025 - Present",
        title = "软件工程师",
        institution = "影石 Insta360",
        location = "深圳",
        description = "来到影像产品的一线，在快速变化的浪潮里写代码，很多想法还在路上，也慢慢长出自己的样子",
        type = TimelineType.WORK,
        highlight = true,
    ),
    TimelineEntry(
        dateRange = "2025 Summer",
        title = "软件开发实习生",
        institution = "Bilibili (哔哩哔哩)",
        location = "上海",
        description = "在视频与社区的流动里做移动端开发，学着理解内容背后那些细密的工程节奏",
        type = TimelineType.WORK,
    ),
    TimelineEntry(
        dateRange = "2025",
        title = "Leetcode Bootcamp Top 1",
        institution = "NYU Tandon School of Engineering",
        location = "纽约",
        description = "算法训练营第一名，那些密集的题目和模拟面试，后来沉成了一点关于结构、耐心和直觉的经验",
        type = TimelineType.ACHIEVEMENT,
        highlight = true,
    ),
    TimelineEntry(
        dateRange = "2024 - 2026",
        title = "M.S. Computer Science",
        institution = "NYU Tandon School of Engineering",
        location = "纽约 · 布鲁克林",
        description = "在布鲁克林读计算机科学，白天是系统与算法，夜里常有桥、风和写不完的作业",
        type = TimelineType.EDUCATION,
        highlight = true,
    ),
    TimelineEntry(
        dateRange = "2024",
        title = "交换生",
        institution = "UC Irvine",
        location = "加州 · 尔湾",
        description = "在尔湾交换学习，阳光很足，课程也紧，关于 CS 的另一种节奏从那里开始显形",
        type = TimelineType.EDUCATION,
    ),
    TimelineEntry(
        dateRange = "2023 Summer",
        title = "软件开发实习生",
        institution = "Xiaomi (小米)",
        location = "北京",
        description = "参与移动端应用开发，第一次更近地看见大规模用户产品如何被一点点打磨",
        type = TimelineType.WORK,
    ),
    TimelineEntry(
        dateRange = "2022 Summer",
        title = "软件开发实习生",
        institution = "Feishu / Lark (字节跳动)",
        location = "深圳 / 北京",
        description = "在协作办公产品里实习，接触 SaaS 与效率工具，也开始理解清晰和克制的价值",
        type = TimelineType.WORK,
    ),
    TimelineEntry(
        dateRange = "2020 - 2024",
        title = "B.E. 软件工程 (建筑学转专业)",
        institution = "华中科技大学 (HUST)",
        location = "武汉",
        description = "从建筑学转入软件工程，做过校园里的「1037 树洞空间」，有些转弯后来才知道，是道路本身",
        type = TimelineType.EDUCATION,
        highlight = true,
    ),
)
