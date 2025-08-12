object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
          if (factors.isEmpty()) return 0

        // Tập hợp để lưu trữ các số bội số duy nhất
        val multiples = mutableSetOf<Int>()

        // Duyệt qua từng factor
        for (factor in factors) {
            if (factor == 0) continue // Bỏ qua 0 để tránh chia cho 0 hoặc lặp vô hạn

            // Lấy bội số của factor, bắt đầu từ factor, nhỏ hơn limit
            var multiple = factor
            while (multiple < limit) {
                multiples.add(multiple) // Thêm vào tập hợp (tự động loại trùng)
                multiple += factor
            }
        }

        // Tính tổng các phần tử duy nhất đã tìm được
        return multiples.sum()
    }
}
