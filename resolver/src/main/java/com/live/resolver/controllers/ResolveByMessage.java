package com.live.resolver.controllers;

import com.live.resolver.dtos.CompletedRoundDTO;
import com.live.resolver.model.ResolvedRound;
import com.live.resolver.services.SemiRandomResolverServiceImplementation;
import com.live.resolver.services.SimplestResolverServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/resolve")
@RequiredArgsConstructor
public class ResolveByMessage {
    @Qualifier("simplest")
    private final SimplestResolverServiceImpl simplestResolverService;
    @Qualifier("randomish")
    private final SemiRandomResolverServiceImplementation randomish;

    @PostMapping
    ResolvedRound resolvedRound(@RequestBody CompletedRoundDTO completedRoundDTO){
        ResolvedRound result = simplestResolverService.resolveRound(completedRoundDTO);
        return result;
    }

    @PostMapping
    ResolvedRound resolveRound(
            @RequestBody CompletedRoundDTO completedRound){

        Random random = new Random();
        double dieRoll = random.nextDouble();
        ResolvedRound result = null;

        if(dieRoll < 0.5){
            result = simplestResolverService.resolveRound(completedRound);
        }
        else {
            result = randomish.resolveRound(completedRound);
        }

        return result;
    }


    // Get for testing
    @GetMapping
    ResolvedRound justTesting(){
        CompletedRoundDTO testInput = new CompletedRoundDTO(
                1L,
                "Simplest Test Round",
                "VegardFraIntelliJ",
                "MariusFraIntelliJ"
        );
        return simplestResolverService.resolveRound(testInput);
    }
}
