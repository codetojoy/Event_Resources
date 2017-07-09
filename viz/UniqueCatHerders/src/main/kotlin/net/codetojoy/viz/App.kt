
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

    val inputLines = File(templateHtml).readLines()
    val outputLines = buildOutputLines(monthOutputs, inputLines)

    File(outputHtml).printWriter().use { out ->
        outputLines.forEach { out.println(it) }
    }

    println("Ready.")
}

fun buildMonthOutputs(records: List<CSVRecord>): List<MonthOutput> {
    var allNames = setOf<String>()
    var sanitizer = CatHerderExtractor() 

    val monthInputs = records.map { MonthInput(it, sanitizer) }

    val monthOutputs = monthInputs.map { monthInput ->
        val monthOutput = transform(monthInput, allNames)
        allNames = monthOutput.allNames
        monthOutput
    }

    return monthOutputs
}

fun buildOutputLines(monthOutputs: List<MonthOutput>, inputLines: List<String>): List<String> {
    val dataRows = monthOutputs.map {
        "[${formatDate(it.date)}, ${it.allNames.size}], // ${it.allNames}"
    }

    val newLines = inputLines.map { line ->
        if (line == DATA_ROWS_TOKEN) dataRows else listOf(line)
    }

    return newLines.flatten()
}
