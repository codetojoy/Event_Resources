
package net.codetojoy.viz

import org.apache.commons.csv.*

class MonthOutput {
    val monthInput: MonthInput
    val uniqueSpeakers: Set<String> 

    constructor(monthInput:MonthInput, allSpeakers: Set<String>) {
        this.monthInput = monthInput
        this.uniqueSpeakers = HashSet(allSpeakers)
    }
}
