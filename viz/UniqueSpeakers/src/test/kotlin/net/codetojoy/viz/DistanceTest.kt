
package net.codetojoy.viz

import kotlin.test.*
import org.junit.Test

class DistanceTestSource {
    @Test fun testIsCloseMatch_String() {
        val s = "jb rainsberger"
        val t = "j.b. rainsberger"
        
        // test
        val result = s.isCloseMatch(t)

        assertTrue(result)
    }

    @Test fun testContainsCloseMatch_Set() {
        val s = setOf("jb rainsberger")
        val t = "j.b. rainsberger"
        
        // test
        val result = s.containsCloseMatch(t)

        assertTrue(result)
    }

    @Test fun testFindDistance_DiffTwo() {
        val s = "jb rainsberger"
        val t = "j.b. rainsberger"
        
        // test
        val result = findDistance(s,t)

        assertEquals(2, result)
    }

    @Test fun testFindDistance_DiffOne() {
        val s = "bear"
        val t = "beer"
        
        // test
        val result = findDistance(s,t)

        assertEquals(1, result)
    }

    @Test fun testFindDistance_Same() {
        val s = "Eddie Van Halen"
        val t = "Eddie Van Halen" 
        
        // test
        val result = findDistance(s,t)

        assertEquals(0, result)
    }

    @Test fun testFindDistance_SameEmpty() {
        val s = ""
        val t = ""
        
        // test
        val result = findDistance(s,t)

        assertEquals(0, result)
    }
}
