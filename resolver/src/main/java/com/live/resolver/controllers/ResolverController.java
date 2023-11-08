package com.live.resolver.controllers;

import com.live.resolver.dtos.CompletedRoundDTO;
import com.live.resolver.model.ResolvedRound;
import com.live.resolver.services.SimplestResolverServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resolve")
@RequiredArgsConstructor
public class ResolverController {
    private final SimplestResolverServiceImpl simplestResolverService;
    // Post Completed Round --> Resolved


    @PostMapping
    ResolvedRound resolvedRound(@RequestBody CompletedRoundDTO completedRoundDTO){
        ResolvedRound result = simplestResolverService.resolveRound(completedRoundDTO);
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
