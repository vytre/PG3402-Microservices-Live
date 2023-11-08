package com.live.ongoing.model;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class Round {
    Long id;
    String description;
    HashMap<Long, String> candidates;

    String secretInfoNotToSend;

    public Round() {
        this.id = 42L;
        this.description = "Do not use defaults";
        this.candidates = new HashMap<>();
        candidates.put(1L, "tancred");
        candidates.put(2L, "Bohemond");
        this.secretInfoNotToSend = "Do Not Send This as a Message";
    }

    public boolean isDuel(){
        return candidates.size() == 2;
    }

    public boolean isComplete(){
        return true;
    }
}
