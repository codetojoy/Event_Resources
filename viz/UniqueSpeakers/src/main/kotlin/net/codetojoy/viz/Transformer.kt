
package net.codetojoy.viz

val MATCH_DISTANCE = 4

fun transform(monthInput: MonthInput, allSpeakers: Set<String>): MonthOutput {
    val speakers = HashSet(allSpeakers)

    monthInput.speakers.forEach { speaker ->
        if (isUnique(speaker, allSpeakers)) {
            speakers.add(speaker)
        }
    }

    val result = MonthOutput(monthInput, speakers)

    return result
}

fun isUnique(speaker: String, allSpeakers: Set<String>) = 
    (allSpeakers.find { it.isCloseMatch(speaker, MATCH_DISTANCE) } == null) 
