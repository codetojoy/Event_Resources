
package net.codetojoy.viz

import java.io.*

import org.apache.commons.csv.*

fun main(args: Array<String>) {
    val csvFile = args[0]

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

    println("\"Date\", \"Number\"")
    monthOutputs.forEach {
        val date = formatDate(it.monthInput.date)
        println("[${date}, ${it.uniquePeople.size}],")
        println("${it.uniquePeople}")
    }

    println("Ready.")
}
