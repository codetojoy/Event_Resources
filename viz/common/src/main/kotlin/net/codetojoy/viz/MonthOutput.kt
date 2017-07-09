
package net.codetojoy.viz

class MonthOutput {
    val date: String
    val allNames: Set<String> 

    constructor(monthInput:MonthInput, allNames: Set<String>) {
        this.date = monthInput.date
        this.allNames = HashSet(allNames)
    }
}
