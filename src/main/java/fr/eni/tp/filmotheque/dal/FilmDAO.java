package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;

import java.util.List;

public interface FilmDAO {
    List<Film> create (Film film);

    Film read(long id);

    List<Film> findAll();

    Film findTitre(long id);

}
