
package net.codetojoy.viz

fun transform(monthInput: MonthInput, allNames: Set<String>): MonthOutput {
    val names = HashSet(allNames)

    monthInput.names.forEach { name ->
        if (allNames.isRelativelyUnique(name)) {
            names.add(name)
        }
    }

    val result = MonthOutput(monthInput, names)

    return result
}
