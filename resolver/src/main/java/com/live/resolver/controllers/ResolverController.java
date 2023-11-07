package com.live.resolver.controllers;

import com.live.resolver.dtos.CompletedRoundDTO;
import com.live.resolver.services.ResolverService;
import com.live.resolver.services.SimplestResolverServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resolve")
@RequiredArgsConstructor
public class ResolverController {
    private final SimplestResolverServiceImpl simplestResolverService;
    // Post Completed Round --> Resolved

    // Get for testing
    @GetMapping
    String justTesting(){
        CompletedRoundDTO testInput = new CompletedRoundDTO(
                1L,
                "Simplest Test Round",
                "Vegard",
                "Marius"
        );
        return simplestResolverService.resolvedRound(testInput);
    }
}
