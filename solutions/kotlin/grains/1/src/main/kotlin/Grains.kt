import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
         // Kiểm tra đầu vào: ô phải từ 1 đến 64
        if (number !in 1..64) {
            throw IllegalArgumentException("Square number must be between 1 and 64")
        }
        
        // Số hạt trên ô thứ n là 2^(n-1)
        // Sử dụng BigInteger để xử lý số lớn
        return BigInteger.TWO.pow(number - 1)
    }
    

    fun getTotalGrainCount(): BigInteger {
        // Tổng số hạt = 2^1 + 2^2 + ... + 2^63 = 2^64 - 1
        // Sử dụng công thức tổng dãy lũy thừa: (2^n - 1) với n = 64
        return BigInteger.TWO.pow(64) - BigInteger.ONE
    }
}
