package com.live.resolver.services;

import com.live.resolver.dtos.CompletedRoundDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SimplestResolverServiceImpl implements ResolverService{
    @Override
    public String resolvedRound(CompletedRoundDTO completedRound) {
        // return "Service basic test";
        return resolveRoundRandom(completedRound);
    }

    public String resolveRound(CompletedRoundDTO completedRound, double dieRoll){
        if (dieRoll < 0.5) {
            return completedRound.getCandidateA() + " won";
        }else {
            return completedRound.getCandidateB() + " won";
        }
    }
    public String resolveRoundRandom(CompletedRoundDTO completedRound){
        Random random = new Random();
        double number = random.nextDouble();

        return resolveRound(completedRound, number);
    }
}
