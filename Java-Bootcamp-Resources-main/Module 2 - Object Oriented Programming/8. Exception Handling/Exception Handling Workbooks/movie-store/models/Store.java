package models;

import java.util.ArrayList;

public class Store {
    private ArrayList<Movie> movies;    

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie (this.movies.get(index));
    }

    public Movie getMovie(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public void action(String movieName, String action) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("There are no movies!");
        }
        if (movieName == null || movieName.isBlank()) {
            throw new IllegalArgumentException("Invalid Movie Name");
        }
        if (!(action.equals("sell") || action.equals("rent") || action.equals("return"))) {
            throw new IllegalArgumentException("Invalid action");
        }
        for (Movie movie : movies) {
            
            if(movie.getName().equalsIgnoreCase(movieName)){
                switch (action) {
                    case "sell": 
                        if(!movie.isAvailable()) {
                            throw new IllegalStateException("Sorry movie is rented out");
                        }
                        this.movies.remove(movie); break;
                    case "rent": movie.setAvailable(false); break;
                    case "return":movie.setAvailable(true); break;
                    default: break;
                }
            }
        }
    }

    public String toString() {
        String temp = "";
        for (Movie movie : movies) {
            temp += movie.toString() + "\n\n";
        }
        return temp;
    }
}


