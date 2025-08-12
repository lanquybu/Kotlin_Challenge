class Clock(hour: Int, minute: Int) {

    private var totalMinutes: Int = normalizeTime(hour * 60 + minute)

    // Hàm chuẩn hóa số phút về khoảng 0..1439 (tức là trong 1 ngày)
    private fun normalizeTime(minutes: Int): Int {
        val modulo = minutes % 1440
        return if (modulo >= 0) modulo else modulo + 1440
    }

    fun add(minutes: Int) {
        totalMinutes = normalizeTime(totalMinutes + minutes)
    }

    fun subtract(minutes: Int) {
        totalMinutes = normalizeTime(totalMinutes - minutes)
    }

    override fun toString(): String {
        val hour = totalMinutes / 60
        val minute = totalMinutes % 60
        return "%02d:%02d".format(hour, minute)
    }

    override fun equals(other: Any?): Boolean {
        return other is Clock && this.totalMinutes == other.totalMinutes
    }

    override fun hashCode(): Int {
        return totalMinutes
    }
}