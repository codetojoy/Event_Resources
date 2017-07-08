
package net.codetojoy.viz

import org.apache.commons.csv.CSVRecord

interface SanitizerInterface {
    fun sanitize(record: CSVRecord): List<String>
}
