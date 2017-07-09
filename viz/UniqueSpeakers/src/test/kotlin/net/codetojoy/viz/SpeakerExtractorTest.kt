
package net.codetojoy.viz

import kotlin.test.assertEquals
import org.junit.Test

class SpeakerExtractorTestSource {
    val speakerExtractor = SpeakerExtractor()

    @Test fun testSanitize_Multiple() {
        val t = "Randy Rhoads/Steve Vai"
        
        // test
        val result = speakerExtractor.sanitize(t)

        val expected = listOf("randy rhoads", "steve vai")
        assertEquals(expected, result)
    }

    @Test fun testSanitize_Kooperman() {
        val s = "kooperman"
        
        // test
        val result = speakerExtractor.sanitize(s)

        assertEquals(listOf(), result)
    }

    @Test fun testSanitize_OpenForum() {
        val s = "open forum"
        
        // test
        val result = speakerExtractor.sanitize(s)

        assertEquals(listOf(), result)
    }

    @Test fun testSanitize_WhiteSpace() {
        val s = "  "
        
        // test
        val result = speakerExtractor.sanitize(s)

        assertEquals(listOf<String>(), result)
    }

    @Test fun testSanitize_Basic() {
        val s = "Bob Dole"
        
        // test
        val result = speakerExtractor.sanitize(s)

        assertEquals(listOf("bob dole"), result)
    }

    @Test fun testSanitize_Unknown() {
        val s = " ? "
        
        // test
        val result = speakerExtractor.sanitize(s)

        assertEquals(listOf(), result)
    }

    @Test fun testGetTokens_Basic() {
        val s = "abc,def/ijk"
        
        // test
        val result = speakerExtractor.getTokens(s)

        assertEquals(listOf("abc","def","ijk"), result)
    }
}
