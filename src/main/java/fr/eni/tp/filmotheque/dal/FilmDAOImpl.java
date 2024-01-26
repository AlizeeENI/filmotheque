package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FilmDAOImpl implements FilmDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Film> create(Film film) {
        String sql = "CREATE * FROM [FILM];";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Film.class));
    }

    @Override
    public Film read(long id) {
        String sql = "SELECT * FROM [FILM] where id = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Film.class), id);
    }

    @Override
    public List<Film> findAll() {
        String sql = "SELECT (*) FROM FILM;";
        List<Film> film = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Film.class));
        return film;
    }

    @Override
    public Film findTitre(long id) {
        String sql = "SELECT titre FROM [FILM] where id = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Film.class), id);
    }

}
