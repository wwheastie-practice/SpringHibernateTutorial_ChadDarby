package net.heastie.mvc;

import java.util.LinkedHashMap;

public class FavoriteProgrammingLanguages {

    private LinkedHashMap<String, String> programmingLanguageOptions;

    public FavoriteProgrammingLanguages() {
        programmingLanguageOptions = new LinkedHashMap<String, String>();

        programmingLanguageOptions.put("Java", "Java");
        programmingLanguageOptions.put("C#", "C#");
        programmingLanguageOptions.put("PHP", "PHP");
        programmingLanguageOptions.put("Ruby", "Ruby");
    }

    public LinkedHashMap<String, String> getProgrammingLanguageOptions() {
        return programmingLanguageOptions;
    }
}
