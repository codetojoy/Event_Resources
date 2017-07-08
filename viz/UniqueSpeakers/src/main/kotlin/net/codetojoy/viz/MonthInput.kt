
package net.codetojoy.viz

import org.apache.commons.csv.*

class MonthInput {
    val date: String
    val speakers: List<String> 

    internal val DATE = "Date"

    constructor(record: CSVRecord) {
        this.date = record.get(DATE) 
        this.speakers = Sanitizer().sanitize(record) 
    }

    constructor(date: String, speakers: List<String>) {
        this.date = date
        this.speakers = speakers
    }
}
