package com.live.resolver.model;


import com.live.resolver.dtos.CandidateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class CompletedRound {
    Long id;
    String description;

    CandidateDTO candidateA;

    CandidateDTO candidateB;
}
