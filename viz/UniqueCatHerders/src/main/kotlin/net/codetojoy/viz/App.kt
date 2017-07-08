
package net.codetojoy.viz

import java.io.*

import org.apache.commons.csv.*

fun main(args: Array<String>) {
    val csvFile = args[0]

    val reader = FileReader(csvFile)
    val records = CSVFormat.EXCEL.withHeader().parse(reader).getRecords()

    records.reverse()

    var allCatHerders = setOf<String>()
    var sanitizer = CatHerderSanitizer() 

    val monthInputs = records.map { MonthInput(it, sanitizer) }

    val monthOutputs = monthInputs.map { monthInput ->
        val monthOutput = transform(monthInput, allCatHerders) 
        allCatHerders = monthOutput.uniqueSpeakers
        monthOutput
    }

    monthOutputs.forEach {
        val date = formatDate(it.monthInput.date)
        println("[${date}, ${it.uniqueSpeakers.size}],")
        println("${it.uniqueSpeakers}")
    }

    println("Ready.")
}
