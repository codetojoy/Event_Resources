
package net.codetojoy.viz

import kotlin.test.assertEquals
import org.junit.Test

class CatHerderExtractorTestSource {
    val catHerderExtractor = CatHerderExtractor()

    @Test fun testExtractNames_WhiteSpace() {
        val s = "  "
        
        // test
        val result = catHerderExtractor.sanitize(s)

        assertEquals(listOf<String>(), result)
    }

    @Test fun testExtractNames_Basic() {
        val s = "Bob Dole"
        
        // test
        val result = catHerderExtractor.sanitize(s)

        assertEquals(listOf("bob dole"), result)
    }
}
