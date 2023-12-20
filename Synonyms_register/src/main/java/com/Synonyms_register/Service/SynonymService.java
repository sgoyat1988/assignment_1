package com.Synonyms_register.Service;

import java.util.List;

public interface SynonymService {
	
	List<String> getSynonyms(String wordName);
	
    void addSynonym(String wordName, String synonym);

	void deleteSynonym(String word, String synonym);

}
