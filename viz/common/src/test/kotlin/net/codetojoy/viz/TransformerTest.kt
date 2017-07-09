
package net.codetojoy.viz

import kotlin.test.*
import org.junit.Test

class TransformerTestSource {

    @Test fun testTransformer_Collision() {
        val date = "FEB 2015"
        val speakers = listOf("Mozart", "JS Bach")
        val monthInput = MonthInput(date, speakers)
        val names = setOf("J.S. Bach", "Chopin")
        
        // test
        val result = transform(monthInput, names)

        assertEquals(3, result.allNames.size)
        assertTrue(result.allNames.contains("J.S. Bach"))
        assertTrue(result.allNames.contains("Chopin"))
        assertTrue(result.allNames.contains("Mozart"))
    }

    @Test fun testTransformer_Basic() {
        val date = "FEB 2015"
        val speakers = listOf("Mozart", "Beethoven")
        val monthInput = MonthInput(date, speakers)
        val names = setOf("Bach", "Chopin")
        
        // test
        val result = transform(monthInput, names)

        assertEquals(4, result.allNames.size)
        assertTrue(result.allNames.contains("Bach"))
        assertTrue(result.allNames.contains("Beethoven"))
        assertTrue(result.allNames.contains("Chopin"))
        assertTrue(result.allNames.contains("Mozart"))
    }
}
