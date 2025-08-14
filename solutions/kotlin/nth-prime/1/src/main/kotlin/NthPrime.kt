import kotlin.math.sqrt
object Prime {
    private val primes: MutableList<Int> = mutableListOf(2, 3)
    fun nth(n: Int): Int {
        if (n == 0) { throw IllegalArgumentException("There is no zeroth prime.") }
        (primes.size until n).forEach { primes += primes[it - 1].nextPrime() }
        return primes[n - 1]
    }
    private fun Int.nextPrime(): Int {
        var candidate = this + 2
        while (!candidate.isPrime()) { candidate += 2 }
        return candidate
    }
    private fun Int.isPrime() =
        (2..sqrt(toDouble()).toInt()).none { this % it == 0 }
}
