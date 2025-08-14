object WordCount {
    fun phrase(s: String): Map<String, Int> = s.toLowerCase()
            .split("[^a-zA-Z_0-9']".toRegex())
            .map { it.trim(' ', '\t', '\n', '\r', '\'') }
            .filterNot { it.isEmpty() }
            .groupingBy { it }.eachCount()
}
