
package net.codetojoy.viz

import org.apache.commons.csv.*

class MonthOutput {
    val monthInput: MonthInput
    val uniquePeople: Set<String> 

    constructor(monthInput:MonthInput, allPeople: Set<String>) {
        this.monthInput = monthInput
        this.uniquePeople = HashSet(allPeople)
    }
}
