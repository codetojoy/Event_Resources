
package net.codetojoy.viz

import kotlin.test.assertEquals
import org.junit.Test

class DistanceTestSource {
    val distance = Distance()

    @Test fun testFindDistance_DiffTwo() {
        val s = "jb rainsberger"
        val t = "j.b. rainsberger"
        
        // test
        val result = distance.findDistance(s,t)

        assertEquals(2, result)
    }

    @Test fun testFindDistance_DiffOne() {
        val s = "bear"
        val t = "beer"
        
        // test
        val result = distance.findDistance(s,t)

        assertEquals(1, result)
    }

    @Test fun testFindDistance_Same() {
        val s = "Eddie Van Halen"
        val t = "Eddie Van Halen" 
        
        // test
        val result = distance.findDistance(s,t)

        assertEquals(0, result)
    }

    @Test fun testFindDistance_SameEmpty() {
        val s = ""
        val t = ""
        
        // test
        val result = distance.findDistance(s,t)

        assertEquals(0, result)
    }
}
