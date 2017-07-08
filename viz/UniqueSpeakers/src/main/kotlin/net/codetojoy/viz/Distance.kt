
package net.codetojoy.viz

val MATCH_DISTANCE = 4

fun String.isCloseMatch(s: String): Boolean {
    return (findDistance(this, s) <= MATCH_DISTANCE) 
}

fun Set<String>.isRelativelyUnique(s: String) = 
    (this.find { it.isCloseMatch(s) } == null)

// https://en.wikipedia.org/wiki/Levenshtein_distance#Iterative_With_Full_Matrix

fun findDistance(s: String, t:String): Int {
    val m = s.length
    val n = t.length

    val d = Array(m+1) { IntArray(n+1) }

    for (i in 1..m) { d[i][0] = i }
    for (j in 1..n) { d[0][j] = j }

    for (j in 1..n) {
        for (i in 1..m) {
            val cost = if (s[i-1] == t[j-1]) 0 else 1 

            val results = listOf(
                d[i-1][j] + 1,      // deletion
                d[i][j-1] + 1,      // insertion
                d[i-1][j-1] + cost  // substitution
            ) 

            d[i][j] = results.min()!!
        }
    } 

    return d[m][n]
}
