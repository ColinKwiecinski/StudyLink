import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;


public class IntervalMatcher {
    LocalTime firstStart;
    LocalTime firstEnd;
    LocalTime secondStart;
    LocalTime secondEnd;


    public IntervalMatcher(LocalTime f1, LocalTime f2, LocalTime s1, LocalTime s2) {
        this.firstStart = f1;
        this.firstEnd = f2;
        this.secondStart = s1;
        this.secondEnd = s2;
    }

    public boolean hasOverlap() {
        boolean result = true;
        if (secondStart.isAfter(firstEnd) || firstStart.isAfter(secondEnd)) {
            result = false;
        }
        return result;
    }

    public long overlapAmount() {
        long firstDuration = firstStart.until(firstEnd, MINUTES);
        long secondDuration = secondStart.until(secondEnd, MINUTES);
        return Math.abs(firstDuration - secondDuration);
    }
}
