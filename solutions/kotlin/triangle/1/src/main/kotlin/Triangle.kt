class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

     // Chuyển các cạnh về dạng Double để dễ xử lý
    private val sideA = a.toDouble()
    private val sideB = b.toDouble()
    private val sideC = c.toDouble()

    init {
        // Kiểm tra độ dài các cạnh phải > 0
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw IllegalArgumentException("All sides must be greater than 0.")
        }

        // Kiểm tra bất đẳng thức tam giác
        if (sideA + sideB < sideC || sideB + sideC < sideA || sideA + sideC < sideB) {
            throw IllegalArgumentException("Triangle inequality violated.")
        }
    }

    // Tam giác đều: tất cả các cạnh bằng nhau
    val isEquilateral: Boolean
        get() = sideA == sideB && sideB == sideC

    // Tam giác cân: có ít nhất hai cạnh bằng nhau
    val isIsosceles: Boolean
        get() = sideA == sideB || sideB == sideC || sideA == sideC

    // Tam giác thường: tất cả các cạnh khác nhau
    val isScalene: Boolean
        get() = sideA != sideB && sideB != sideC && sideA != sideC
}
