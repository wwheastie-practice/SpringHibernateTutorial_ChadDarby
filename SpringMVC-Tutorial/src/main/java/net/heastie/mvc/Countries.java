package net.heastie.mvc;

import java.util.LinkedHashMap;

public class Countries {

    private LinkedHashMap<String, String> countryOptions;

    public Countries () {
        countryOptions = new LinkedHashMap<String, String>();

        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
        countryOptions.put("US", "United States");
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }
}
