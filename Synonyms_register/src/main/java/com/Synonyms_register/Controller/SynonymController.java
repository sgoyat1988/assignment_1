package com.Synonyms_register.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Synonyms_register.Service.SynonymService;

@RestController
@RequestMapping("/api/synonyms")
public class SynonymController {
	private final SynonymService synonymService;

	@Autowired
	public SynonymController(SynonymService synonymService) {
		this.synonymService = synonymService;
	}

	@GetMapping("/{word}")
	public ResponseEntity<List<String>> getSynonyms(@PathVariable String word) {
		List<String> synonyms = synonymService.getSynonyms(word);
		return ResponseEntity.ok(synonyms);
	}

	@PostMapping("/{word}")
	public ResponseEntity<Void> addSynonym(@PathVariable String word, @RequestBody String synonym) {
		synonymService.addSynonym(word, synonym);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{word}")
	public ResponseEntity<Void> deleteSynonym(@PathVariable String word, @RequestBody String synonym) {
		synonymService.deleteSynonym(word, synonym);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
