/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DBconnection.GenreFactory;
import DBconnection.MovieFactory;
import Entity.Genre;
import Entity.Movie;
import Entity.MovieCharacter;
import Entity.MovieGenre;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Scope;

/**
 *
 * @author Firas
 */
@ManagedBean
@Named("movieController")
@RequestScoped

public class movieController implements Serializable{
    
    public void addNewMovie(String title, int year, int regisseur, char type, List<String> genres) throws ClassNotFoundException, SQLException{
        Movie movie = new Movie();
        //MovieCharacter movieCharacters = new MovieCharacter();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setRegisseur(regisseur);
        movie.setType(type);
        movie.insert();
        
        movie = MovieFactory.findMovieByTitle(title);
       
        for(int i = 0; i < genres.size(); i++){
            MovieGenre mg = new MovieGenre();
            String genreString = genres.get(i);
            Genre genre = GenreFactory.findGenreByName(genreString);
           /* mg.setMovieId(movie.getId());
            mg.setGenreId(genreList.get(0).getGenreId());
            System.out.println(genreList.get(0).getGenreId());
            mg.insert();*/
        }
       
    }
    
}
