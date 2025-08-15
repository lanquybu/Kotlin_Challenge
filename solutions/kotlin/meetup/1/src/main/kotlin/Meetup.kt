import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.*
data class Meetup(val month: Int, val year: Int) {
    fun day(dayOfWeek: DayOfWeek, scheduleDay: MeetupSchedule): LocalDate {
        val d = LocalDate.of(year, month, 1)
        if (scheduleDay == MeetupSchedule.FIRST){
            return d.with(TemporalAdjusters.firstInMonth(dayOfWeek))
        }
        if (scheduleDay == MeetupSchedule.SECOND){
            return d.with(TemporalAdjusters.firstInMonth(dayOfWeek)).plusDays(7)
        }
        if (scheduleDay == MeetupSchedule.THIRD) {
            return d.with(TemporalAdjusters.firstInMonth(dayOfWeek)).plusDays(14)
        }
        if (scheduleDay == MeetupSchedule.FOURTH){
            return d.with(TemporalAdjusters.firstInMonth(dayOfWeek)).plusDays(21)
        }
        if (scheduleDay == MeetupSchedule.LAST){
            return d.with(TemporalAdjusters.lastInMonth(dayOfWeek))
        }
        if (scheduleDay == MeetupSchedule.TEENTH){
            return if ((d.with(TemporalAdjusters.firstInMonth(dayOfWeek)).plusDays(7).dayOfMonth > 12)
                    and (d.with(TemporalAdjusters.firstInMonth(dayOfWeek)).plusDays(7).dayOfMonth < 20)){
                d.with(TemporalAdjusters.firstInMonth(dayOfWeek)).plusDays(7)
            }
            else return d.with(TemporalAdjusters.firstInMonth(dayOfWeek)).plusDays(14)
        }
        return LocalDate.MAX
    }
}