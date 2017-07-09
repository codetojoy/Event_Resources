
package net.codetojoy.viz

import org.apache.commons.csv.CSVRecord

class MonthInput {
    val date: String
    val names: List<String> 

    internal val DATE = "Date"

    constructor(record: CSVRecord, extractor: Extractor) {
        this.date = record.get(DATE) 
        this.names = extractor.extractNames(record) 
    }

    constructor(date: String, names: List<String>) {
        this.date = date
        this.names = names
    }
}
