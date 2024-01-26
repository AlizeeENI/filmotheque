package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Participant;

import java.util.List;

public interface ParticipantDAO {

    Participant read(long id);

    List<Participant> findAll();

    List<Participant> findActeurs(long idFilm);

    List<Participant> createActeur(long idParticipant, long idFilm);
}
