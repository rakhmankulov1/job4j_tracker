package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        String key = citizen.getPassport();
        if (!citizens.containsKey(key)) {
            citizens.put(key, citizen);
            rsl=true;
        }
        return rsl;
    }


    public Citizen get(String passport) {
        return citizens.get(passport) ;
    }
}
