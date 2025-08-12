object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            val guess = list[mid]

            when {
                guess == item -> return mid
                guess < item -> left = mid + 1
                else -> right = mid - 1
            }
        }

        throw NoSuchElementException("Item not found in list")
    }
}