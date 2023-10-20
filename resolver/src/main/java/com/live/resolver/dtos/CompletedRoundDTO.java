package com.live.resolver.dtos;


import lombok.Value;

@Value
public class CompletedRoundDTO {
    long id;
    String description;

    String candidateA;
    String candidateB;
}
