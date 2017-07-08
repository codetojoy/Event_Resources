
package net.codetojoy.viz

import org.joda.time.*
import org.joda.time.format.*

fun formatDate(s: String): String {
    val dateTime = DateTimeFormat.forPattern("MMM yyyy").parseDateTime(s)
    val dateStr = DateTimeFormat.forPattern("yyyy-MM-dd").print(dateTime)
    return "new Date('${dateStr}')"
}
