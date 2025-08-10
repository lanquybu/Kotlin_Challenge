object EliudsEggs {

    fun eggCount(number: Int): Int{
         // Kiểm tra nếu số đầu vào âm, trả về 0 vì bài toán chỉ xử lý số không âm
        if (number < 0) return 0
        
        // Khởi tạo biến đếm số bit 1
        var count = 0
        // Tạo biến tạm để xử lý, tránh thay đổi số đầu vào
        var temp = number
        
        // Lặp cho đến khi temp bằng 0
        while (temp > 0) {
            // Kiểm tra bit cuối cùng bằng phép AND với 1
            count += temp and 1
            // Dịch phải temp để kiểm tra bit tiếp theo
            temp = temp shr 1
        }
        
        // Trả về số bit 1, tương ứng với số trứng
        return count
    }
}
