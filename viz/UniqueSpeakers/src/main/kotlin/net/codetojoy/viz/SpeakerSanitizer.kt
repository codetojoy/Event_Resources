
package net.codetojoy.viz

import org.apache.commons.csv.*

class SpeakerSanitizer : SanitizerInterface {
    internal val UNKNOWN = "?"

    internal val SPEAKER_1 = "Speaker 1"
    internal val SPEAKER_2 = "Speaker 2"

    internal val SEPARATORS_REGEX = Regex(",|\\/")

    internal val IGNORE_LIST = listOf("kooperman", "open forum", "?")
    
    override fun sanitize(record: CSVRecord): List<String> {
        val speaker1 = record.get(SPEAKER_1)
        val speaker2 = record.get(SPEAKER_2)
        val result = sanitize(speaker1, speaker2)

        return result
    }

    internal fun sanitize(s1: String, s2: String) = sanitize(s1) + sanitize(s2)

    internal fun sanitize(s: String): List<String> {
        val results = mutableListOf<String>()

        val trimStr = s.trim()

        if (! trimStr.isEmpty()) {
            val tokens = getTokens(s)

            tokens.forEach { token ->
                results.add(token.trim().toLowerCase())
            }
        }

        return results.toList().filter { ! IGNORE_LIST.contains(it) }
    }

    internal fun getTokens(s: String) = SEPARATORS_REGEX.split(s)
}
