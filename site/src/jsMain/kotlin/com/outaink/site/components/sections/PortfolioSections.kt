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
            H1(attrs = { attr("id", "hero-title") }) { Text("你好，我是 Outaink") }
            P(attrs = { classes("intro") }) {
                Text("从华科建筑系的图纸，到 NYU 夜里的算法题，再到 Insta360 的影像现场，代码有时像一条小路，带我走向产品、城市，也走向一些尚未说完的生活")
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
            SectionTitle("关于我")
            Div(attrs = { classes("about-grid") }) {
                P(attrs = { classes("bio-text") }) {
                    Text("曾经画建筑的线，后来写软件的行，一路从华科到纽约，再回到深圳的海风里，仍然相信小而确定的东西：一个界面、一段代码、一件慢慢成形的作品")
                }
                Div(attrs = { classes("skill-board"); attr("aria-label", "技能列表") }) {
                    Skill("Kotlin / Android", "从校园里的 1037 树洞，到影像产品的真实现场，慢慢把想法放进口袋里的屏幕")
                    Skill("编程语言 & 虚拟机", "写解释器和小小的虚拟机，像在纸上搭一间能运行的房子")
                    Skill("产品工程", "在飞书、小米、Bilibili 的不同节奏里，学会让工程贴近人的日常")
                    Skill("算法 & 竞赛", "NYU Leetcode Bootcamp 2025 Top 1，复杂问题拆开以后，也会有清亮的一面")
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
            SectionTitle("写过的项目")
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
            SectionTitle("停留过的地方")
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
                H2 { Text("慢慢写，也慢慢生活") }
                P { Text("这个像素小站，收着一些项目、路过的城市、技术里的念头，以及生活偶尔留下的光；若你愿意，可以从 GitHub 或个人站继续往下看") }
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
