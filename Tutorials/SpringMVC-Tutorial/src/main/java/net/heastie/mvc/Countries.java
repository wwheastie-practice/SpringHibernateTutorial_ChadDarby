package net.heastie.mvc;

import java.util.LinkedHashMap;

public class Countries {

    private LinkedHashMap<String, String> options;

    public Countries () {
        options = new LinkedHashMap<String, String>();

        options.put("BR", "Brazil");
        options.put("FR", "France");
        options.put("DE", "Germany");
        options.put("IN", "India");
        options.put("US", "United States");
    }

    public LinkedHashMap<String, String> getOptions() {
        return options;
    }
}
