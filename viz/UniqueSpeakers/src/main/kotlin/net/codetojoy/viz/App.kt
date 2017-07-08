
package net.codetojoy.viz

import java.io.*

import org.apache.commons.csv.*

fun main(args: Array<String>) {
    val csvFile = args[0]
    val templateHtml = args[1]
    val outputHtml = args[2] 

    val reader = FileReader(csvFile)
    val records = CSVFormat.EXCEL.withHeader().parse(reader).getRecords()

    records.reverse()

    var allPeople = setOf<String>()
    var speakerSanitizer = SpeakerSanitizer()

    val monthInputs = records.map { MonthInput(it, speakerSanitizer) }

    val monthOutputs = monthInputs.map { monthInput ->
        val monthOutput = transform(monthInput, allPeople) 
        allPeople = monthOutput.uniquePeople
        monthOutput
    }

    val dataRows = monthOutputs.map { 
        "[${formatDate(it.monthInput.date)}, ${it.uniquePeople.size}], // ${it.uniquePeople}"
    }

    val newLines: List<List<String>> = File(templateHtml).readLines().map { line ->
        if (line == "__DATA_ROWS") dataRows else listOf(line) 
    }

    val outputLines = newLines.flatten()

    File(outputHtml).printWriter().use { out ->
        outputLines.forEach { out.println(it) }
    }

    println("Ready.")
}
