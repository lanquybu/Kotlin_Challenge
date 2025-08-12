class Anagram(private val target: String) {

    // Chuẩn hóa chuỗi: chuyển về lowercase và sắp xếp ký tự
    private fun normalize(word: String): String =
        word.lowercase().toCharArray().sorted().joinToString("")

    fun match(anagrams: Collection<String>): Set<String> {
        val normalizedTarget = normalize(target)
        val targetLower = target.lowercase()

        return anagrams
            .filter {
                it.lowercase() != targetLower && normalize(it) == normalizedTarget
            }
            .toSet()
    }
}
