package com.live.resolver.services;

import com.live.resolver.dtos.CompletedRoundDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SimplesResolverServiceImpl implements ResolverService{
    @Override
    public String resolvedRound(CompletedRoundDTO completedRound) {

        return "Service basic test";
    }

    public String resolveRound(CompletedRoundDTO completedRoundDTO){
        Random random = new Random();
        double num = random.nextDouble();

    }

    public String resolveRoundRandom(CompletedRoundDTO completedRound){
        Random random = new Random();
        double num = random.nextDouble();

        if (num < 0.5){
            return "Candidate A won";
        }else {
            return "Candidate B wom";
        }
    }

}
