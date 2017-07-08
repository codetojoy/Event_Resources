
package net.codetojoy.viz

import kotlin.test.assertEquals
import org.junit.Test

class CatHerderSanitizerTestSource {
    val sanitizer = CatHerderSanitizer()

    @Test fun testSanitize_WhiteSpace() {
        val s = "  "
        
        // test
        val result = sanitizer.sanitize(s)

        assertEquals(listOf<String>(), result)
    }

    @Test fun testSanitize_Basic() {
        val s = "Bob Dole"
        
        // test
        val result = sanitizer.sanitize(s)

        assertEquals(listOf("bob dole"), result)
    }
}
