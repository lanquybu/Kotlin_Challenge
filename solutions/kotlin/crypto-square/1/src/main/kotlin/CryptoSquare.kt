import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        // 1) Chuẩn hóa: giữ chữ + số, bỏ khoảng trắng & dấu, hạ chữ thường
        val normalized = plaintext
            .filter { it.isLetterOrDigit() }
            .lowercase()

        // Trường hợp rỗng
        if (normalized.isEmpty()) return ""

        // 2) Tính kích thước hình chữ nhật r x c
        val n = normalized.length
        val s = sqrt(n.toDouble())
        var r = floor(s).toInt()
        var c = ceil(s).toInt()
        if (r * c < n) r++  // đảm bảo r*c >= n, c >= r, c - r <= 1

        // 3) Fill lưới theo hàng, pad ' ' cho thiếu
        val grid = Array(r) { CharArray(c) { ' ' } }
        var idx = 0
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (idx < n) grid[i][j] = normalized[idx++] else break
            }
        }

        // 4) Đọc theo cột, ghép c chunk, mỗi chunk dài r, ngăn bằng khoảng trắng
        val out = StringBuilder()
        for (j in 0 until c) {
            for (i in 0 until r) out.append(grid[i][j])
            if (j != c - 1) out.append(' ')
        }
        return out.toString()
    }
}
