class Allergies(private val score: Int) {
    // TODO: implement proper constructor to complete the task

     fun isAllergicTo(allergen: Allergen): Boolean {
        return (score and allergen.score) != 0
    }

    fun getList(): List<Allergen> {
        return Allergen.values().filter { isAllergicTo(it) }
    }
}
