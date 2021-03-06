package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public String showResult() {
        return "시작시간: " + format(startDateTime);
    }

    public int checkCapacity(int people) {
        if ((capacity - people) < 0) {
            throw new IllegalArgumentException("## 매진입니다.");
        }
        capacity = capacity - people;
        return people;

    }

    public LocalDateTime getStarTime() {
        return startDateTime;
    }
}
