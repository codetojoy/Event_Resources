
package net.codetojoy.viz

import java.io.*

import org.apache.commons.csv.*

val DATA_ROWS_TOKEN = "__DATA_ROWS"

fun main(args: Array<String>) {
    val csvFile = args[0]
    val templateHtml = args[1]
    val outputHtml = args[2] 

    val reader = FileReader(csvFile)
    val records = CSVFormat.EXCEL.withHeader().parse(reader).getRecords()
    records.reverse()

    val monthOutputs = buildMonthOutputs(records)

    val outputLines = buildOutputLines(monthOutputs, templateHtml)

    File(outputHtml).printWriter().use { out ->
        outputLines.forEach { out.println(it) }
    }

    println("Ready.")
}

fun buildMonthOutputs(records: List<CSVRecord>): List<MonthOutput> {
    var allPeople = setOf<String>()
    val speakerSanitizer = SpeakerSanitizer()

    val monthInputs = records.map { MonthInput(it, speakerSanitizer) }

    val monthOutputs = monthInputs.map { monthInput ->
        val monthOutput = transform(monthInput, allPeople) 
        allPeople = monthOutput.uniquePeople
        monthOutput
    }

    return monthOutputs
} 

fun buildOutputLines(monthOutputs: List<MonthOutput>, templateHtml: String): List<String> {
    val dataRows = monthOutputs.map { 
        "[${formatDate(it.monthInput.date)}, ${it.uniquePeople.size}], // ${it.uniquePeople}"
    }

    val newLines: List<List<String>> = File(templateHtml).readLines().map { line ->
        if (line == DATA_ROWS_TOKEN) dataRows else listOf(line) 
    }

    return newLines.flatten()
}
