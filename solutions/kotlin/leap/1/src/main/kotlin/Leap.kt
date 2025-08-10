data class Year(val year: Int) {
 val isLeap: Boolean
     get() = when {
            // Nếu năm chia hết cho 400, là năm nhuận
            year % 400 == 0 -> true
            // Nếu năm chia hết cho 100 nhưng không chia hết cho 400, không phải năm nhuận
            year % 100 == 0 -> false
            // Nếu năm chia hết cho 4 nhưng không chia hết cho 100, là năm nhuận
            year % 4 == 0 -> true
            // Các trường hợp còn lại không phải năm nhuận
            else -> false
}
}
