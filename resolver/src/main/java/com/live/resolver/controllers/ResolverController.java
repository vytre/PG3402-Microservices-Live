package com.live.resolver.controllers;

import com.live.resolver.dtos.CompletedRoundDTO;
import com.live.resolver.services.SimplesResolverServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resolve")

public class ResolverController {
    // POST Completed round --> resolved
    private final SimplesResolverServiceImpl simplest;

    public ResolverController(SimplesResolverServiceImpl simplest) {
        this.simplest = simplest;
    }

    // GET for testing
    @GetMapping
    String justTesting(){

        CompletedRoundDTO testInput = new CompletedRoundDTO(
                1L,
                "Something",
                "V",
                "B"
        );

        return simplest.resolvedRound("Doesnt Matter");

    }
}
