object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        // Kiểm tra nếu số đầu vào không phải số nguyên dương
        if (start <= 0) {
            throw IllegalArgumentException("Input must be a positive integer")
        }
        
        // Biến đếm số bước
        var steps = 0
        // Biến lưu giá trị hiện tại, bắt đầu từ số đầu vào
        var current = start
        
        // Lặp cho đến khi current bằng 1
        while (current != 1) {
            // Nếu current là số chẵn, chia 2
            if (current % 2 == 0) {
                current /= 2
            } 
            // Nếu current là số lẻ, nhân 3 rồi cộng 1
            else {
                current = current * 3 + 1
            }
            // Tăng số bước sau mỗi lần áp dụng quy tắc
            steps++
        }
        
        // Trả về số bước đã đếm được
        return steps
    }
}
