package fr.eni.tp.filmotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Membre;

@Controller
@RequestMapping("/avis") // Injection de la liste des attributs en session
@SessionAttributes({ "membreEnSession" })
public class AvisController {

	private FilmService filmService;
	
	public AvisController(FilmService filmService) {
		this.filmService = filmService;
	}

	// Création d'un nouvel avis
	@GetMapping("/creer")
	public String creerAvis(@RequestParam("idFilm") long idFilm, Model model,
	@ModelAttribute("membreEnSession") Membre membreEnSession) {
		if (membreEnSession != null && membreEnSession.getId() >= 1) {
		// Il y a un membre en session
		// Mise en session du titre du film sélectionné et de son id
			String titre = filmService.consulterTitreFilm(idFilm);
			if ( titre != null) {
				model.addAttribute("titreFilm", titre);
				model.addAttribute("idFilm", idFilm);
				Avis avis = new Avis();
				// Ajout de l'instance du formulaire dans le modèle
				model.addAttribute("avis", avis);
				return "view-avis-form";
			}
		}
		return "redirect:/films";
	}

	// Récupération de l'objet opinion du formulaire
	// sauvegarde
	@PostMapping("/creer")
	public String creerAvis(@ModelAttribute("avis") Avis avis,
		@RequestParam(name = "idFilm", required = true) long idFilm,
		@ModelAttribute("membreEnSession") Membre membreEnSession) {
		if (membreEnSession != null && membreEnSession.getId() >= 1) {
			// Il y a un membre en session
			avis.setMembre(membreEnSession);
			System.out.println(avis);
			// Sauvegarde de l’avis avec l’identifiant du film :
			filmService.publierAvis(avis, idFilm);
		}
		// Redirection vers la liste des films :
		return "redirect:/films";
	}
}
