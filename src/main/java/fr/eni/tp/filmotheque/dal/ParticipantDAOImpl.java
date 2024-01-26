package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipantDAOImpl implements ParticipantDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Participant read(long id) {
        String sql = "SELECT * FROM [PARTICIPANT] where id = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Participant.class), id);
    }

    @Override
    public List<Participant> findAll() {
        String sql = "SELECT (*) FROM PARTICIPANT;";
        List<Participant> participant = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participant.class));
        return participant;
    }

    @Override
    public List<Participant> findActeurs(long idFilm) {
        return null;
    }

    @Override
    public Object createActeur(long idParticipant, long idFilm) {
       return null;
    }
}
