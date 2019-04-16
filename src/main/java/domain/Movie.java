package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    public String showBooks() {
        return String.format(id + " - " + name + ", " + price + "원");
    }

    public boolean movieMatchOf(int id) {
        return (id == this.id);
    }

    public PlaySchedule checkSchedue(int scheduleId, List<ScheduleMovie> books) {
        if(playSchedules.size() < scheduleId){
            throw new IllegalArgumentException("해당 영화가 없습니다.");
        }

        for(ScheduleMovie book : books){
            if(book.checkTime(playSchedules.get(scheduleId).getStarTime())){
                throw new IllegalArgumentException("1시간 이내 입니다.");
            }
        }

        return playSchedules.get(scheduleId);

    }

    public int getPrice(){
        return price;
    }

}
