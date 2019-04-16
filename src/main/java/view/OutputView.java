package view;

import domain.Movie;
import domain.ScheduleMovie;

import java.util.List;

public class OutputView {
    private static final char NEW_LINE = '\n';

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printEachMovie(Movie movie) {
        System.out.print(movie);
    }

    public static void printBooks(List<ScheduleMovie> books){
        for(ScheduleMovie each : books){
            System.out.println(each.toString());
        }
    }

    public static String printResultCalcue(float discount,int point, int money){
        int discountedMoney = money - point;

        return String.format("최종 결제한 금액은 "+ checkPoint(discountedMoney,discount)+"원 입니다."+NEW_LINE+
        "예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }

    public static float checkPoint(int money, float discount){
        if(money <= 0){
            return 0;
        }
        return money - ( money * discount);
    }

}
