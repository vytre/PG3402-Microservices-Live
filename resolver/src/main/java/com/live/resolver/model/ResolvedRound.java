package com.live.resolver.model;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResolvedRound {
    @Id
    @Generated
    Long id;
    Long sourceId;

    String candidateA;
    String candidateB;

    String description;

    public String outcome;
}
