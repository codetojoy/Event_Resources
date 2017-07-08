
package net.codetojoy.viz

import org.apache.commons.csv.CSVRecord

class MonthInput {
    val date: String
    val people: List<String> 

    internal val DATE = "Date"

    constructor(record: CSVRecord, sanitizer: SanitizerInterface) {
        this.date = record.get(DATE) 
        this.people = sanitizer.sanitize(record) 
    }

    constructor(date: String, people: List<String>) {
        this.date = date
        this.people = people
    }
}
