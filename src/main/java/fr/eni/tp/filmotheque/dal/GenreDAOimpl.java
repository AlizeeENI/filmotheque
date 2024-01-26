package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class GenreDAOimpl implements GenreDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Genre read(long id){
        String sql = "SELECT * FROM [GENRE] where id = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Genre.class), id);
    }
@Override
    public List<Genre> findAll() {
        String sql = "SELECT (*) FROM GENRE;";
        List<Genre> genre = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Genre.class));
        return genre;
    }
}

