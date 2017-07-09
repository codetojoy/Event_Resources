
package net.codetojoy.viz

import org.apache.commons.csv.CSVRecord

interface Extractor {
    fun extractNames(record: CSVRecord): List<String>
}
