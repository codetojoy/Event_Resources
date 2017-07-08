
package net.codetojoy.viz

import kotlin.test.*
import org.junit.Test

class AppTestSource {
// fun buildOutputLines(monthOutputs: List<MonthOutput>, inputLines: List<String>): List<String> {

    // ugh, this is messy
    @Test fun testBuildOutputLines_Basic() {
        val inputLines = listOf("header", "body", DATA_ROWS_TOKEN, "footer") 

        val setA = setOf<String>("Bach", "Chopin")
        val setB = setA + setOf<String>("Mozart", "Paganini")

        val monthInputA = MonthInput("JAN 2017", listOf("Bach","Chopin"))
        val monthInputB = MonthInput("FEB 2017", listOf("Mozart","Paganini"))

        val monthOutputs = listOf(MonthOutput(monthInputA, setA), 
                                  MonthOutput(monthInputB, setB))
        
        // test
        val result = buildOutputLines(monthOutputs, inputLines)

        assertEquals(5, result.size)
        assertEquals("header", result[0])
        assertEquals("body", result[1])

        assertTrue(result[2].contains("new Date('2017-01-01'), 2"))
        assertTrue(result[3].contains("new Date('2017-02-01'), 4"))

        assertEquals("footer", result[4])
    }
}
