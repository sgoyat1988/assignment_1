package com.Synonyms_register.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Synonyms_register.Domain.Synonyms;
import com.Synonyms_register.Domain.Word;

public interface SynonymsRepo extends JpaRepository<Synonyms, Long> {

	List<Synonyms> findByWord(Word word);
}
