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
    type = "现居住地",
    status = "Current",
    coordinateLabel = "South China",
    description = "现居住地。这里靠近海，也靠近很多正在发生的技术和产品现场，是继续写代码、做项目和积累灵感的起点。",
)
