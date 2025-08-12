object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val digits = input.toString().map { it.toString().toInt() }
        val power = digits.size
        val sum = digits.sumOf { digit -> powerOf(digit, power) }
        return sum == input
    }

    private fun powerOf(base: Int, exponent: Int): Int {
        var result = 1
        repeat(exponent) {
            result *= base
        }
        return result
    }

}
