
package net.codetojoy.viz

import kotlin.test.*
import org.junit.Test

class TransformerTestSource {
    val transformer = Transformer()

    @Test fun testIsUnique_Basic() {
        val speaker = "Mozart"
        val allSpeakers = setOf("Bach", "Chopin")
        
        // test
        val result = Transformer().isUnique(speaker, allSpeakers)

        assertTrue(result)
    }

    @Test fun testIsUnique_Collision() {
        val speaker = "J.B. Rainsberger"
        val allSpeakers = setOf("JB Rainsberger", "Chopin")
        
        // test
        val result = Transformer().isUnique(speaker, allSpeakers)

        assertFalse(result)
    }

    @Test fun testTransformer_Collision() {
        val date = "FEB 2015"
        val speakers = listOf("Mozart", "JS Bach")
        val monthInput = MonthInput(date, speakers)
        val allSpeakers = setOf("J.S. Bach", "Chopin")
        
        // test
        val result = Transformer().transform(monthInput, allSpeakers)

        assertEquals(3, result.uniqueSpeakers.size)
        assertTrue(result.uniqueSpeakers.contains("J.S. Bach"))
        assertTrue(result.uniqueSpeakers.contains("Chopin"))
        assertTrue(result.uniqueSpeakers.contains("Mozart"))
    }

    @Test fun testTransformer_Basic() {
        val date = "FEB 2015"
        val speakers = listOf("Mozart", "Beethoven")
        val monthInput = MonthInput(date, speakers)
        val allSpeakers = setOf("Bach", "Chopin")
        
        // test
        val result = Transformer().transform(monthInput, allSpeakers)

        assertEquals(4, result.uniqueSpeakers.size)
        assertTrue(result.uniqueSpeakers.contains("Bach"))
        assertTrue(result.uniqueSpeakers.contains("Beethoven"))
        assertTrue(result.uniqueSpeakers.contains("Chopin"))
        assertTrue(result.uniqueSpeakers.contains("Mozart"))
    }
}
