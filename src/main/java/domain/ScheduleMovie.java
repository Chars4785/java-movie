package domain;


import utils.DateTimeUtils;

import java.time.LocalDateTime;

public class ScheduleMovie {
    private static final char NEW_LINE = '\n';

    private Movie movie;
    private PlaySchedule schedule;
    private int person;

    public ScheduleMovie(Movie movie, PlaySchedule schedule, int person) {
        this.movie = movie;
        this.schedule = schedule;
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format(movie.showBooks() + NEW_LINE + schedule.showResult() + NEW_LINE +
                "예약 인원 " + person + NEW_LINE);
    }

    public boolean checkTime(LocalDateTime plusTime) {
        return DateTimeUtils.isOneHourWithinRange(plusTime, schedule.getStarTime());
    }

    public int getTotalPrise() {
        return movie.getPrice() * person;
    }
}
