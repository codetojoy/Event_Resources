
package net.codetojoy.viz

fun transform(monthInput: MonthInput, allPeople: Set<String>): MonthOutput {
    val people = HashSet(allPeople)

    monthInput.people.forEach { person ->
        if (allPeople.isRelativelyUnique(person)) {
            people.add(person)
        }
    }

    val result = MonthOutput(monthInput, people)

    return result
}
