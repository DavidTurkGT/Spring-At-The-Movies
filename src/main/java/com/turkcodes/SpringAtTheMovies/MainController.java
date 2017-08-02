package com.turkcodes.SpringAtTheMovies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by David Turk on 8/2/17.
 */
@Controller
public class MainController {
    private static final String API_URL = "https://api.themoviedb.org/3/movie/now_playing";
    private static final String API_KEY = "?api_key=be2a38521a7859c95e2d73c48786e4bb";

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/now-playing")
    public String nowPlaying(Model model){
        List<Movie> movies = getMovies();
        model.addAttribute("movies", movies);
        return "now-playing";
    }

    @RequestMapping("/medium-popular-long-name")
    public String mediumPopularLongName(Model model){
        System.out.print("Getting all movies...");
        List<Movie> allMovies = getMovies();
        System.out.println("Done!");
        System.out.print("Filtering movies...");
        List<Movie> filteredMovies = allMovies.stream()
                                        .filter(x -> x.getTitle().length() >= 10)
                                        .filter(x -> x.getPopularity() >= 30 && x.getPopularity() <= 80)
                                        .collect(Collectors.toList());
        System.out.println("Done!");
        System.out.print("Adding to model...");
        model.addAttribute("movies", filteredMovies);
        System.out.println("Done!");
        System.out.println("Movies to send:");
        filteredMovies.stream().forEach(System.out::println);
        return "medium-popular-long-name";
    }

    @RequestMapping("/overview-mashup")
    public String overviewMashup(){
        return "overview-mashup";
    }

    public static List<Movie> getMovies(){
        RestTemplate template = new RestTemplate();
        ResultsPage response = template.getForObject(API_URL + API_KEY, ResultsPage.class);
        List<Movie> movies = response.getResults();
        return movies;
    }
}
