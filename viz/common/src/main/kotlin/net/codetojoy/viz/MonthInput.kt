
package net.codetojoy.viz

import org.apache.commons.csv.CSVRecord

class MonthInput {
    val date: String
    val people: List<String> 

    internal val DATE = "Date"

    constructor(record: CSVRecord, extractor: Extractor) {
        this.date = record.get(DATE) 
        this.people = extractor.extractNames(record) 
    }

    constructor(date: String, people: List<String>) {
        this.date = date
        this.people = people
    }
}
