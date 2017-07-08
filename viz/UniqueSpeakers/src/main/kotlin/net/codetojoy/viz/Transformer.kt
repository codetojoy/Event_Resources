
package net.codetojoy.viz

fun transform(monthInput: MonthInput, allSpeakers: Set<String>): MonthOutput {
    val speakers = HashSet(allSpeakers)

    monthInput.speakers.forEach { speaker ->
        if (! allSpeakers.containsCloseMatch(speaker)) {
            speakers.add(speaker)
        }
    }

    val result = MonthOutput(monthInput, speakers)

    return result
}
