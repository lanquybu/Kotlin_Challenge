import kotlin.math.abs
typealias Constraint = (Map<String, List<String>>) -> Boolean
val INPUTS = listOf(
    "Nationality" to listOf("Norwegian", "Spaniard", "Englishman", "Japanese", "Ukrainian"),
    "Colour" to listOf("Blue", "Green", "Ivory", "Red", "Yellow"),
    "Drinks" to listOf("Coffee", "Milk", "Orange juice", "Tea", "Water"),
    "Smokes" to listOf("Chesterfields", "Kools", "Lucky strike", "Old gold", "Parliaments"),
    "Pet" to listOf("Dog", "Fox", "Horse", "Snails", "Zebra")
)
val CONSTRAINTS = mapOf<String, List<Constraint>>(
    "Nationality" to listOf({ it["Nationality"]!![0] == "Norwegian" }),
    "Colour" to listOf({ it["Colour"]!!.indexOf("Red") == it["Nationality"]!!.indexOf("Englishman") }, { it["Colour"]!!.indexOf("Green") - it["Colour"]!!.indexOf("Ivory")  == 1 }, { abs(it["Nationality"]!!.indexOf("Norwegian") - it["Colour"]!!.indexOf("Blue")) == 1 }),
    "Drinks" to listOf({ it["Colour"]!!.indexOf("Green") == it["Drinks"]!!.indexOf("Coffee") }, { it["Nationality"]!!.indexOf("Ukrainian") == it["Drinks"]!!.indexOf("Tea") },  { it["Drinks"]!![2] == "Milk" }),
    "Smokes" to listOf({ it["Colour"]!!.indexOf("Yellow") == it["Smokes"]!!.indexOf("Kools") }, { it["Drinks"]!!.indexOf("Orange juice") == it["Smokes"]!!.indexOf("Lucky strike") }, { it["Nationality"]!!.indexOf("Japanese") == it["Smokes"]!!.indexOf("Parliaments") }),
    "Pet" to listOf({ it["Nationality"]!!.indexOf("Spaniard") == it["Pet"]!!.indexOf("Dog") }, { it["Smokes"]!!.indexOf("Old gold") == it["Pet"]!!.indexOf("Snails") }, { abs(it["Smokes"]!!.indexOf("Chesterfields") - it["Pet"]!!.indexOf("Fox")) == 1 }, { abs(it["Smokes"]!!.indexOf("Kools") - it["Pet"]!!.indexOf("Horse")) == 1 })
)
fun <T> Iterable<T>.permutations(): List<Iterable<T>> = when(this.count()) {
    0 -> emptyList()
    1 -> listOf(this)
    else -> this.flatMap { x -> (this - x).permutations().map { y -> y + x } }
}
fun findSolution(inputs: List<Pair<String, List<String>>>, constraints: Map<String, List<Constraint>>): Map<String, List<String>> {
    var solutions: List<Map<String, List<String>>> = listOf(mapOf())
    for ((i,v) in inputs) {
        val perms = v.permutations()
        solutions = solutions.flatMap { m -> perms.map { x -> m + (i to (x.toList())) } }.filter { m -> constraints[i]!!.all { c -> c(m) } }
    }
    if (solutions.isEmpty()) {
        throw IllegalStateException("No solution found")
    }
    return solutions.first()
}
class ZebraPuzzle {
    private val solution by lazy { findSolution(INPUTS, CONSTRAINTS) }
    fun drinksWater(): String {
        return solution["Nationality"]!![solution["Drinks"]!!.indexOf("Water")]
    }
    fun ownsZebra(): String {
        return solution["Nationality"]!![solution["Pet"]!!.indexOf("Zebra")]
    }
}
