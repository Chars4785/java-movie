import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MovieApplication {
    static List<ScheduleMovie> books = new ArrayList<>();
    static List<PlaySchedule> schedules = new LinkedList<>();

    static private int people;
    static private PlaySchedule schedule;

    public static void main(String[] args) {
        do{
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);
            Movie movie = check(movies);
            OutputView.printEachMovie(movie);
            schedule = askSchedule(movie);
            people = askPerson(schedule);
            books.add(new ScheduleMovie(movie,schedule,people));
        } while (askAgain());
        System.out.print(askWay(askPoint()));
    }

    public static Movie check(List<Movie> movies) {
        try {
            int movieId = InputView.inputMovieId();
            return findMovie(movies, movieId);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return check(movies);
        }
    }

    public static Movie findMovie(List<Movie> movies,int movieId){
        for(Movie movie: movies){
            if(movie.movieMatchOf(movieId)){
                return movie;
            }
        }
        throw new IllegalArgumentException("없는 영화표 입니다.");
    }

    public static PlaySchedule askSchedule(Movie movie) {
        try{
            int scheduleId = InputView.inputScheduleId();
            return movie.checkSchedue(scheduleId -1,books);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return askSchedule(movie);
        }
    }

    public static int askPerson(PlaySchedule schedule){
        try{
            int person = InputView.inputPerson();
            return schedule.checkCapacity(person);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return askPerson(schedule);
        }
    }

    public static boolean askAgain(){
        try{
            int again = InputView.inputAgain();
            return checkAgain(again);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return askAgain();
        }
    }

    public static boolean checkAgain(int again){
        if(again == 1){
            OutputView.printBooks(books);
            return false;
        }
        return true;
    }

    public static int askPoint(){
        try{
            int point = InputView.inputPoint();
            return checkPoint(point);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return askPoint();
        }
    }

    public static int checkPoint(int point){
        if(point < 0){
            throw new IllegalArgumentException("포인트는 0 이상입니다.");
        }
        return point;
    }

    public static String askWay(int point){
        try{
            int way = InputView.inputWay();
            return checkWay(way,point);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return askWay(point);
        }
    }

    public static int getTotalPrise(){
        int sum=0;
        for(ScheduleMovie each : books){
            sum += each.getTotalPrise();
        }
        return sum;
    }

    public static String checkWay(int way, int point){
        if(way == 1 || way == 2){
            return OutputView.printResultCalcue(Discount.valueOf(way).getDiscountRate(),point,getTotalPrise());
        }

        throw new IllegalArgumentException("잘못 입력했습니다.");
    }

}