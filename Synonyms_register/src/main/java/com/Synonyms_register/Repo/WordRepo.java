package com.Synonyms_register.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Synonyms_register.Domain.Word;

public interface WordRepo extends JpaRepository<Word, Long> {
	
	Optional<Word> findByName(String name);

	void deleteByName(String word);

}
