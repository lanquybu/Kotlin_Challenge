import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.pow
class Gigasecond(initialDate: LocalDateTime) {
    // A gigasecond is 10^9 (1,000,000,000) seconds.
    val gigaSeconds = 1e9.toLong()
    val date = initialDate.plusSeconds(gigaSeconds)
    constructor(initialDate: LocalDate) : this(initialDate.atStartOfDay())
}