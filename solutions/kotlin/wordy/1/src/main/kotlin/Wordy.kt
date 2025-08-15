import kotlin.math.pow
object Wordy {
    private enum class Operation(val op: (Int, Int) -> Int) {
        Plus({ a, b -> a + b }),
        Minus({ a, b -> a - b }),
        MultipliedBy({ a, b -> a * b }),
        DividedBy({ a, b -> a / b }),
        PowerOf({ a, b -> a.toDouble().pow(b.toDouble()).toInt() })
    }
    private fun op(a: String, op: String, b: String) =
        Operation.valueOf(op).op(a.toInt(), b.toInt())
    private fun ans(input: String): Int {
        val words = input.trim().split(' ')
        return when (words.size) {
            1 -> words[0].toInt()
            else -> ans("${op(words[0], words[1], words[2])} ${words.drop(3).joinToString(" ")}")
        }
    }
    private const val whatIs = "What is "
    fun answer(input: String): Int =
        when (input.startsWith(whatIs)) {
            true -> ans(
                input.drop(whatIs.length)
                    .dropLast(1)
                    .replace("plus", Operation.Plus.name)
                    .replace("minus", Operation.Minus.name)
                    .replace("multiplied by", Operation.MultipliedBy.name)
                    .replace("divided by", Operation.DividedBy.name)
                    .replace("raised to the", Operation.PowerOf.name)
                    .replace("th power", "")
            )
            else -> throw Exception()
        }
}