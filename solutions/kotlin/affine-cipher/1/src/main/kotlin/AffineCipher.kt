import java.util.Locale
object AffineCipher {
    fun encode(input: String, a: Int, b: Int): String {
        require(a.coprime(26)) { "a and m must be coprime." }
        val text = input.lowercase(Locale.getDefault()).filter { it.isLetterOrDigit() }
        val encoded = text.map {
            when {
                it.isDigit() -> it
                else -> it.affineCipherEncode(a, b)
            }
        }.joinToString("")
        return encoded.chunked(5).joinToString(" ")
    }
    fun decode(input: String, a: Int, b: Int): String {
        require(a.coprime(26)) { "a and m must be coprime." }
        val text = input.filter { it.isLetterOrDigit() }
        val inverse = a.modularMultiplicativeInverse() // Đã sửa thuật toán tính nghịch đảo
        return text.map {
            if (it.isDigit()) it else decodeChar(it, b, inverse)
        }.joinToString("")
    }
    // Tính ước số chung lớn nhất
    private tailrec fun Int.gcd(other: Int): Int = if (other == 0) this else other.gcd(this % other)
    // Kiểm tra số nguyên tố cùng nhau
    private fun Int.coprime(other: Int): Boolean = this.gcd(other) == 1
    // Thuật toán Euclid mở rộng để tìm nghịch đảo modulo
    private fun Int.modularMultiplicativeInverse(mod: Int = 26): Int {
        var a = this
        var m = mod
        var x0 = 0
        var x1 = 1
        while (a > 1) {
            val q = a / m
            var t = m
            m = a % m
            a = t
            t = x0
            x0 = x1 - q * x0
            x1 = t
        }
        if (x1 < 0) x1 += mod
        return x1
    }
    private fun decodeChar(c: Char, b: Int, inverse: Int): Char {
        val index = c.affineCipherIndex()
        val product = (inverse * (index - b)).mod(26) // Tránh số âm
        return product.toAffineCipherChar()
    }
    private fun Char.affineCipherEncode(a: Int, b: Int): Char =
        ((a * this.affineCipherIndex() + b) % 26).toAffineCipherChar()
    private fun Char.affineCipherIndex(): Int = this.code - 'a'.code
    private fun Int.toAffineCipherChar(): Char = (this + 'a'.code).toChar()
}
