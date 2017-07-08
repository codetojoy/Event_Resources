
package net.codetojoy.viz

import kotlin.test.*
import org.junit.Test

class TransformerTestSource {

    @Test fun testTransformer_Collision() {
        val date = "FEB 2015"
        val speakers = listOf("Mozart", "JS Bach")
        val monthInput = MonthInput(date, speakers)
        val allPeople = setOf("J.S. Bach", "Chopin")
        
        // test
        val result = transform(monthInput, allPeople)

        assertEquals(3, result.uniquePeople.size)
        assertTrue(result.uniquePeople.contains("J.S. Bach"))
        assertTrue(result.uniquePeople.contains("Chopin"))
        assertTrue(result.uniquePeople.contains("Mozart"))
    }

    @Test fun testTransformer_Basic() {
        val date = "FEB 2015"
        val speakers = listOf("Mozart", "Beethoven")
        val monthInput = MonthInput(date, speakers)
        val allPeople = setOf("Bach", "Chopin")
        
        // test
        val result = transform(monthInput, allPeople)

        assertEquals(4, result.uniquePeople.size)
        assertTrue(result.uniquePeople.contains("Bach"))
        assertTrue(result.uniquePeople.contains("Beethoven"))
        assertTrue(result.uniquePeople.contains("Chopin"))
        assertTrue(result.uniquePeople.contains("Mozart"))
    }
}
