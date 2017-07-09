
package net.codetojoy.viz

import org.apache.commons.csv.CSVRecord

class CatHerderExtractor : Extractor {
    internal val CAT_HERDER = "Cat Herder"

    override fun extractNames(record: CSVRecord): List<String> {
        val catHerder = record.get(CAT_HERDER)
        val result = sanitize(catHerder)

        return result
    }

    internal fun sanitize(s: String): List<String> {
        val results = mutableListOf<String>()

        val trimStr = s.trim()

        if (! trimStr.isEmpty()) {
            results.add(trimStr.toLowerCase())
        }

        return results.toList()
    }
}
