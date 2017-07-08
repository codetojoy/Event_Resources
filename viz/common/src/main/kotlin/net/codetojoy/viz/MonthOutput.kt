
package net.codetojoy.viz

class MonthOutput {
    val date: String
    val uniquePeople: Set<String> 

    constructor(monthInput:MonthInput, allPeople: Set<String>) {
        this.date = monthInput.date
        this.uniquePeople = HashSet(allPeople)
    }
}
