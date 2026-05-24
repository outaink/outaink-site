package com.outaink.site.components.sections

import androidx.compose.runtime.Composable
import com.outaink.site.data.timelineEntries
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun TimelineSection() {
    Section(attrs = { classes("timeline-band"); id("journey"); attr("aria-labelledby", "timeline-title") }) {
        Div(attrs = { classes("section-inner") }) {
            SectionTitle("个人经历")
            Div(attrs = { classes("timeline"); attr("role", "list") }) {
                timelineEntries.forEachIndexed { index, entry ->
                    TimelineEntryCard(entry, isLeft = index % 2 == 0)
                }
            }
        }
    }
}

@Composable
private fun TimelineEntryCard(entry: com.outaink.site.data.TimelineEntry, isLeft: Boolean) {
    val sideClass = if (isLeft) "left" else "right"
    val typeClass = "timeline-type-${entry.type.name.lowercase()}"
    val entryClasses = listOfNotNull(
        "timeline-entry",
        sideClass,
        "highlight".takeIf { entry.highlight },
        typeClass,
    )

    Div(attrs = {
        classes(*entryClasses.toTypedArray())
        attr("role", "listitem")
    }) {
        Span(attrs = { classes("timeline-dot"); attr("aria-hidden", "true") })
        Div(attrs = { classes("timeline-badge") }) {
            Span(attrs = { classes("timeline-date") }) { Text(entry.dateRange) }
        }
        Div(attrs = { classes("timeline-content") }) {
            H3 { Text(entry.title) }
            Span(attrs = { classes("timeline-institution") }) { Text("${entry.institution} · ${entry.location}") }
            P { Text(entry.description) }
        }
    }
}
