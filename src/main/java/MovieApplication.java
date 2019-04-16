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
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);
            Movie movie = check(movies);
            OutputView.printEachMovie(movie);
            schedule = askSchedule(movie);
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
            return movie.checkSchedue(scheduleId -1);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return askSchedule(movie);
        }
    }

}