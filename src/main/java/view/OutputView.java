package view;

import domain.Movie;
import domain.ScheduleMovie;

import java.util.List;

public class OutputView {
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

}
