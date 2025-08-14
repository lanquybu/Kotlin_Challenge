object RunLengthEncoding {
    fun encode(input: String): String =
        if (input.isEmpty()) ""
        else input.drop(1)
            .fold(mutableListOf(Pair(input[0], 1))) { pairs, chr ->
                val (c, n) = pairs[pairs.lastIndex]
                if (c == chr) pairs[pairs.lastIndex] = Pair(c, n + 1)
                else pairs += Pair(chr, 1)
                pairs
            }
            .joinToString("") { (c, n) ->
                (if (n == 1) "" else n.toString()) + c
            }
    fun decode(input: String): String =
        input.replace(Regex("(\\d+)(.)")) {
            it.groupValues[2].repeat(it.groupValues[1].toInt())
        }
}
