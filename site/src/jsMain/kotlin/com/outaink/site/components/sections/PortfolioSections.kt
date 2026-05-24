package com.outaink.site.components.sections

import androidx.compose.runtime.Composable
import com.outaink.site.data.Footprint
import com.outaink.site.data.GitHubRepo
import com.outaink.site.data.currentFootprint
import com.outaink.site.data.pinnedRepos
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Article
import org.jetbrains.compose.web.dom.Aside
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
private fun ExternalLink(href: String, className: String? = null, text: String) {
    A(
        href = href,
        attrs = {
            className?.split(" ")?.filter { it.isNotEmpty() }?.forEach { classes(it) }
            attr("target", "_blank")
            attr("rel", "noreferrer")
        }
    ) {
        Text(text)
    }
}

@Composable
fun PortfolioHeader() {
    Header(attrs = { classes("topbar") }) {
        Nav(attrs = { classes("nav"); attr("aria-label", "主导航") }) {
            A(href = "#home", attrs = { classes("brand"); attr("aria-label", "返回首页") }) {
                Span(attrs = { classes("brand-mark"); attr("aria-hidden", "true") })
                Span { Text("OUTAINK.LOG") }
            }
            Div(attrs = { classes("nav-links") }) {
                A(href = "#about") { Text("简介") }
                A(href = "#journey") { Text("经历") }
                A(href = "#works") { Text("项目") }
                A(href = "#essays") { Text("随笔") }
                A(href = "#footprints") { Text("足迹") }
                A(href = "#contact") { Text("联系") }
            }
        }
    }
}

@Composable
fun HeroSection() {
    Section(attrs = { classes("hero"); attr("aria-labelledby", "hero-title") }) {
        Div {
            P(attrs = { classes("eyebrow") }) { Text("INSTA360 · ANDROID · CREATOR") }
            H1(attrs = { attr("id", "hero-title") }) { Text("你好，我是 Outaink。") }
            P(attrs = { classes("intro") }) {
                Text("为热爱出发，勇闯消费电子行业。从华科建筑系的图纸到 NYU 的算法竞赛，从 1037 树洞空间到 Insta360 的影像世界——我一直在寻找代码与产品的交汇点。这里记录我的项目、随笔和生活灵感。")
            }
            Div(attrs = { classes("hero-actions") }) {
                A(href = "#works", attrs = { classes("pixel-button") }) { Text("查看项目") }
                ExternalLink("https://github.com/outaink", "pixel-button secondary", "打开 GitHub")
            }
        }

        Aside(attrs = { classes("profile-panel"); attr("aria-label", "个人简介卡片") }) {
            Div(attrs = { classes("window-bar"); attr("aria-hidden", "true") }) {
                Span(attrs = { classes("dot") })
                Span(attrs = { classes("dot") })
                Span(attrs = { classes("dot") })
            }
            Div(attrs = { classes("photo-wrap") }) {
                Img(src = "assets/personal-head.jpg", alt = "个人头图", attrs = { classes("headshot") })
            }
            Ul(attrs = { classes("profile-list") }) {
                ProfileItem("定位", "Android / Kotlin / 消费电子")
                ProfileItem("GitHub", "outaink")
                ProfileItem("城市", "深圳 · Insta360")
            }
        }
    }
}

@Composable
private fun ProfileItem(label: String, value: String) {
    Li {
        B { Text(label) }
        Span { Text(value) }
    }
}

@Composable
fun AboutSection() {
    Section(attrs = { classes("about-band"); attr("id", "about") }) {
        Div(attrs = { classes("section-inner") }) {
            SectionTitle("个人简介")
            Div(attrs = { classes("about-grid") }) {
                P(attrs = { classes("bio-text") }) {
                    Text("从华科建筑系转专业到软件工程，到 NYU 计算机硕士毕业，如今在 Insta360 做消费电子——每一步都是因为对「做出好东西」的执着。这个主页保留像素感，因为它像代码里的小方块：简单、明确，拼起来就能形成一个世界。")
                }
                Div(attrs = { classes("skill-board"); attr("aria-label", "技能列表") }) {
                    Skill("Kotlin / Android", "从 HUST 的 1037 树洞空间到 Insta360，用 Android 把产品带给真实用户。")
                    Skill("编程语言 & 虚拟机", "用 Kotlin 和 C 造轮子：解释器、栈式虚拟机和语言运行时实验。")
                    Skill("产品工程", "经历飞书、小米、Bilibili 的实习，感受不同规模产品的工程节奏。")
                    Skill("算法 & 竞赛", "NYU Leetcode Bootcamp 2025 Top 1，享受把复杂问题拆解成清晰步骤的过程。")
                }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Div(attrs = { classes("section-title") }) {
        Span(attrs = { classes("pixel-icon"); attr("aria-hidden", "true") })
        H2 { Text(title) }
    }
}

@Composable
private fun Skill(title: String, text: String) {
    Div(attrs = { classes("skill") }) {
        org.jetbrains.compose.web.dom.B { Text(title) }
        Span { Text(text) }
    }
}

@Composable
fun ProjectsSection() {
    Section(attrs = { attr("id", "works") }) {
        Div(attrs = { classes("section-inner") }) {
            SectionTitle("GitHub 项目")
            Div(attrs = { classes("works-grid") }) {
                pinnedRepos.forEach { ProjectCard(it) }
            }
        }
    }
}

@Composable
private fun ProjectCard(repo: GitHubRepo) {
    Article(
        attrs = {
            classes("work-card")
            style {
                property("--art-a", repo.artA)
                property("--art-b", repo.artB)
                property("--art-c", repo.artC)
            }
        }
    ) {
        Div {
            Div(attrs = { classes("work-art"); attr("aria-hidden", "true") })
            Div(attrs = { classes("repo-meta") }) {
                Span(attrs = { classes("repo-language") }) { Text(repo.language) }
                Span(attrs = { classes("repo-stars") }) { Text("★ ${repo.stars}") }
            }
            H3 { Text(repo.name) }
            P { Text(repo.description) }
        }
        Div(attrs = { classes("tag-row") }) {
            ExternalLink(repo.url, "tag", "Repo ↗")
        }
    }
}

@Composable
fun FootprintsSection(footprint: Footprint = currentFootprint) {
    Section(attrs = { classes("footprints-band"); attr("id", "footprints") }) {
        Div(attrs = { classes("section-inner") }) {
            SectionTitle("我的足迹")
            Div(attrs = { classes("footprints-layout") }) {
                Div(attrs = { classes("map-frame"); attr("aria-label", "以中国为中心的世界地图，标记深圳中国") }) {
                    Div(attrs = { classes("map-stage"); attr("role", "img"); attr("aria-label", "真实世界地图，中心区域为中国与东亚") }) {
                        Div(attrs = { classes("real-map"); attr("aria-hidden", "true") }) {
                            listOf(
                                "osm-z2-1-1.png",
                                "osm-z2-2-1.png",
                                "osm-z2-3-1.png",
                                "osm-z2-0-1.png",
                                "osm-z2-1-2.png",
                                "osm-z2-2-2.png",
                                "osm-z2-3-2.png",
                                "osm-z2-0-2.png",
                            ).forEach { file ->
                                Img(src = "assets/$file", alt = "", attrs = { classes("map-tile") })
                            }
                        }
                        Span(attrs = { classes("map-pin"); attr("aria-hidden", "true") })
                        Span(attrs = { classes("map-label") }) { Text("${footprint.place} / ${footprint.country}") }
                        ExternalLink("https://www.openstreetmap.org/copyright", "map-attribution", "© OpenStreetMap")
                    }
                }
                Aside(attrs = { classes("pin-card"); attr("aria-label", "地点详情") }) {
                    Div {
                        H3 { Text("${footprint.place} / ${footprint.country}") }
                        P { Text(footprint.description) }
                    }
                    Ul(attrs = { classes("pin-meta") }) {
                        PinMeta("类型", footprint.type)
                        PinMeta("状态", footprint.status)
                        PinMeta("坐标", footprint.coordinateLabel)
                    }
                }
            }
        }
    }
}

@Composable
private fun PinMeta(label: String, value: String) {
    Li {
        Span { Text(label) }
        B { Text(value) }
    }
}

@Composable
fun ContactSection() {
    Section(attrs = { classes("contact-band"); attr("id", "contact") }) {
        Div(attrs = { classes("section-inner", "contact-layout") }) {
            Div {
                H2 { Text("保持创造，保持记录。") }
                P { Text("这里是 Outaink 的个人像素主页：记录学习经历、项目实验、生活灵感和日常随笔。欢迎从 GitHub 或个人站继续了解我。") }
            }
            Div(attrs = { classes("contact-links"); attr("aria-label", "联系方式") }) {
                ExternalLink("https://github.com/outaink", text = "github.com/outaink")
                ExternalLink("http://outaink.com/", text = "outaink.com")
                ExternalLink("https://github.com/outaink?tab=repositories", text = "Public Repos")
            }
        }
    }
}

@Composable
fun PortfolioFooter() {
    Footer(attrs = { classes("footer") }) {
        Text("© 2026 OUTAINK.LOG · Built with warm pixels.")
    }
}

@Composable
fun PortfolioPage() {
    Div(attrs = { classes("page") }) {
        PortfolioHeader()
        Main(attrs = { attr("id", "home") }) {
            HeroSection()
            TimelineSection()
            ProjectsSection()
            EssaysSection()
            AboutSection()
            FootprintsSection()
            ContactSection()
        }
        PortfolioFooter()
    }
}
