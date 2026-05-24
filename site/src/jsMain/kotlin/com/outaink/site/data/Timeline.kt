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
        description = "为热爱出发，勇闯消费电子行业。在影像技术的浪潮里，用代码把想法变成真实可用的产品。",
        type = TimelineType.WORK,
        highlight = true,
    ),
    TimelineEntry(
        dateRange = "2025 Summer",
        title = "软件开发实习生",
        institution = "Bilibili (哔哩哔哩)",
        location = "上海",
        description = "加入视频平台技术团队，参与移动端功能开发与优化，感受内容社区的工程节奏。",
        type = TimelineType.WORK,
    ),
    TimelineEntry(
        dateRange = "2025",
        title = "Leetcode Bootcamp Top 1",
        institution = "NYU Tandon School of Engineering",
        location = "纽约",
        description = "算法训练营第一名优胜奖，收获价值约 $500 奖品。在密集的刷题和模拟面试中，打磨了数据结构与算法直觉。",
        type = TimelineType.ACHIEVEMENT,
        highlight = true,
    ),
    TimelineEntry(
        dateRange = "2024 - 2026",
        title = "M.S. Computer Science",
        institution = "NYU Tandon School of Engineering",
        location = "纽约 · 布鲁克林",
        description = "在纽约大学坦登工程学院攻读计算机科学硕士，深入系统、算法与工程实践。",
        type = TimelineType.EDUCATION,
        highlight = true,
    ),
    TimelineEntry(
        dateRange = "2024",
        title = "交换生",
        institution = "UC Irvine",
        location = "加州 · 尔湾",
        description = "加州大学尔湾分校交换学习，体验美式 CS 教育与加州的科技文化氛围。",
        type = TimelineType.EDUCATION,
    ),
    TimelineEntry(
        dateRange = "2023 Summer",
        title = "软件开发实习生",
        institution = "Xiaomi (小米)",
        location = "北京",
        description = "参与小米移动端应用开发，在消费电子巨头的实战中积累大规模用户产品的工程经验。",
        type = TimelineType.WORK,
    ),
    TimelineEntry(
        dateRange = "2022 Summer",
        title = "软件开发实习生",
        institution = "Feishu / Lark (字节跳动)",
        location = "深圳 / 北京",
        description = "加入飞书团队，在协作办公产品的开发中感受 SaaS 与效率工具的独特工程挑战。",
        type = TimelineType.WORK,
    ),
    TimelineEntry(
        dateRange = "2020 - 2024",
        title = "B.E. 软件工程 (建筑学转专业)",
        institution = "华中科技大学 (HUST)",
        location = "武汉",
        description = "从建筑学转入软件工程，开发「1037 树洞空间」——一款火爆校园的社交产品，由此开启了 Android 客户端的职业道路。",
        type = TimelineType.EDUCATION,
        highlight = true,
    ),
)
