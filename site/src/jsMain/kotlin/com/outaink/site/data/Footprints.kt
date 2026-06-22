package com.outaink.site.data

data class Footprint(
    val place: String,
    val country: String,
    val type: String,
    val status: String,
    val coordinateLabel: String,
    val description: String,
)

val currentFootprint = Footprint(
    place = "深圳",
    country = "中国",
    type = "此刻停留",
    status = "Current",
    coordinateLabel = "South China",
    description = "这里靠近海，也靠近很多正在发生的技术和产品现场，写代码、做项目、散步，灵感有时就从这些缝隙里来",
)
