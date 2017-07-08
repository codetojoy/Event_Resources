
package net.codetojoy.viz

import kotlin.test.assertEquals
import org.junit.Test

class SpeakersSanitizerTestSource {
    val sanitizer = SpeakersSanitizer()

    @Test fun testSanitize_MultipleFull() {
        val s = "Eddie Van Halen"
        val t = "Randy Rhoads/Steve Vai"
        
        // test
        val result = sanitizer.sanitize(s,t)

        val expected = listOf("eddie van halen", "randy rhoads", "steve vai")
        assertEquals(expected, result)
    }

    @Test fun testSanitize_Kooperman() {
        val s = "kooperman"
        
        // test
        val result = sanitizer.sanitize(s)

        assertEquals(listOf(), result)
    }

    @Test fun testSanitize_OpenForum() {
        val s = "open forum"
        
        // test
        val result = sanitizer.sanitize(s)

        assertEquals(listOf(), result)
    }

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

    @Test fun testSanitize_Unknown() {
        val s = " ? "
        
        // test
        val result = sanitizer.sanitize(s)

        assertEquals(listOf(), result)
    }

    @Test fun testGetTokens_Basic() {
        val s = "abc,def/ijk"
        
        // test
        val result = sanitizer.getTokens(s)

        assertEquals(listOf("abc","def","ijk"), result)
    }
}
