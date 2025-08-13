object Pangram {
    fun isPangram(input: String): Boolean {
        val alphabet = ('a'..'z')
        return alphabet.all { input.contains(it, true) }
    }
}
