object Bob {
    fun hey(input: String): String {
         val trimmedInput = input.trim()
        
        // Kiểm tra im lặng (chuỗi rỗng hoặc chỉ chứa khoảng trắng)
        if (trimmedInput.isEmpty()) {
            return "Fine. Be that way!"
        }
        
        // Kiểm tra có phải là câu hỏi (kết thúc bằng dấu ?)
        val isQuestion = trimmedInput.endsWith("?")
        
        // Kiểm tra có phải là la hét (tất cả chữ cái là in hoa)
        val hasLetters = trimmedInput.any { it.isLetter() }
        val isYelling = hasLetters && trimmedInput.uppercase() == trimmedInput
        
        return when {
            isYelling && isQuestion -> "Calm down, I know what I'm doing!"
            isYelling -> "Whoa, chill out!"
            isQuestion -> "Sure."
            else -> "Whatever."
    }
    }
}
