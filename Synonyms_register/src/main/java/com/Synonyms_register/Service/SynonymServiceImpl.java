package com.Synonyms_register.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Synonyms_register.Domain.Synonyms;
import com.Synonyms_register.Domain.Word;
import com.Synonyms_register.Repo.SynonymsRepo;
import com.Synonyms_register.Repo.WordRepo;

@Service
public class SynonymServiceImpl implements SynonymService {
	private final WordRepo wordRepository;
	private final SynonymsRepo synonymRepository;

	@Autowired
	public SynonymServiceImpl(WordRepo wordRepository, SynonymsRepo synonymRepository) {
		this.wordRepository = wordRepository;
		this.synonymRepository = synonymRepository;
	}

	@Override
	public List<String> getSynonyms(String wordName) {
		Optional<Word> wordOptional = wordRepository.findByName(wordName);
		if (wordOptional.isPresent()) {
			List<Synonyms> synonyms = synonymRepository.findByWord(wordOptional.get());
			return synonyms.stream().map(Synonyms::getSynonym).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public void addSynonym(String wordName, String synonym) {
		Optional<Word> wordOptional = wordRepository.findByName(wordName);
		if (wordOptional.isPresent()) {
			Word word = wordOptional.get();
			Synonyms newSynonym = new Synonyms();
			newSynonym.setWord(word);
			newSynonym.setSynonym(synonym);
			synonymRepository.save(newSynonym);
		}
	}

	@Override
	public void deleteSynonym(String word, String synonym) {
		wordRepository.deleteByName(word);
	}
}
