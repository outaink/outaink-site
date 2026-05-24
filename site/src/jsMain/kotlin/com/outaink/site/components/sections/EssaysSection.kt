package com.outaink.site.components.sections

import androidx.compose.runtime.Composable
import com.outaink.site.data.recentEssays
import org.jetbrains.compose.web.dom.Article
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun EssaysSection() {
    Section(attrs = { classes("essays-band"); id("essays"); attr("aria-labelledby", "essays-title") }) {
        Div(attrs = { classes("section-inner") }) {
            SectionTitle("随笔")
            Div(attrs = { classes("essays-grid") }) {
                recentEssays.take(3).forEach { essay ->
                    EssayPreviewCard(essay)
                }
            }
        }
    }
}

@Composable
private fun EssayPreviewCard(essay: com.outaink.site.data.Essay) {
    Article(attrs = { classes("essay-card") }) {
        Span(attrs = { classes("essay-date") }) { Text(essay.date) }
        H3 { Text(essay.title) }
        P { Text(essay.summary) }
        Div(attrs = { classes("essay-tags") }) {
            essay.tags.forEach { tag ->
                Span(attrs = { classes("essay-tag") }) { Text(tag) }
            }
        }
    }
}
