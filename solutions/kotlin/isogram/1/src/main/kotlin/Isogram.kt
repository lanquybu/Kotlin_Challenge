object Isogram {

    fun isIsogram(input: String): Boolean {
         // Chuyển chuỗi thành chữ thường và lọc chỉ giữ lại các chữ cái
        val letters = input.lowercase().filter { it.isLetter() }
        
        // So sánh độ dài của tập hợp chữ cái (loại bỏ trùng lặp) với độ dài chuỗi chữ cái
        // Nếu bằng nhau, không có chữ cái nào lặp lại
        return letters.toSet().size == letters.length
    }
}
