
package net.codetojoy.viz

import java.io.*

import org.apache.commons.csv.*

fun main(args: Array<String>) {
    val csvFile = args[0]

    val reader = FileReader(csvFile)
    val records = CSVFormat.EXCEL.withHeader().parse(reader).getRecords()

    records.reverse()

    var allSpeakers = setOf<String>()
    val monthInputs = records.map { MonthInput(it) }

    val monthOutputs = monthInputs.map { monthInput ->
        val monthOutput = transform(monthInput, allSpeakers) 
        allSpeakers = monthOutput.uniqueSpeakers
        monthOutput
    }

    println("\"Date\", \"Number\"")
    monthOutputs.forEach {
        val date = formatDate(it.monthInput.date)
        println("[${date}, ${it.uniqueSpeakers.size}],")
        // println("${it.uniqueSpeakers}")
    }

    println("Ready.")
}
