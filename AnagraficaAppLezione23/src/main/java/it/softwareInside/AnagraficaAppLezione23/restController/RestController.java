package it.softwareInside.AnagraficaAppLezione23.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.AnagraficaAppLezione23.model.Persona;
import it.softwareInside.AnagraficaAppLezione23.service.PersonaService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@Autowired
	PersonaService personaService;
	
	
	
	
	@PostMapping("/aggiungi-persona")
	public boolean addPersona (@RequestBody Persona persona) {
		
		return personaService.addPersona(persona);
	}
	
	
	
	@DeleteMapping("/cancella-persona-cf")
	public Persona deletePersona (@RequestParam (name="cf") String cf) {
		
		return personaService.deletePersonaByCf(cf);
	}
	
	
	
	
	
	@DeleteMapping("/cancella-tutto")
	public boolean deleteAll (@RequestParam (name="pass") String password) {
		
		return personaService.deleteAll(password);
	}
	
	
	
	@PostMapping("/uptade-persona")
	public boolean updatePersona (@RequestBody Persona persona) {
		
		return personaService.updatePersona(persona);
	}
	
	
	
	
	@GetMapping("/tutte-le-persone")
	public Iterable<Persona> stampaPersona () {
		
		return personaService.stampaPersona();
	}
	
	
	
	
	
	@GetMapping("/trova-persona-da-cf")
	public Persona trovaPersonaByCf (@RequestParam (name="cf") String cf) {
		
		return personaService.findPeopleByCf(cf);
	}
	
	
	
	
	@GetMapping("/persone-piu-25-anni") 
	public List<Persona> allPeopleUp25 () {
		
		return personaService.allPeopleUp25();
	}
	
	
	
	
	@GetMapping("/persone-piu-di")
	public List<Persona> allPeopleUp (@RequestParam (name="eta") int eta) {
		
		return personaService.allPeopleUpEta(eta);
	}
	 
	
	
	
}
