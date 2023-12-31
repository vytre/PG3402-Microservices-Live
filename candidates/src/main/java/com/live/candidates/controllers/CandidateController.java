package com.live.candidates.controllers;

import com.live.candidates.model.Candidate;
import com.live.candidates.model.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateRepository candidateRepository;


    @GetMapping("/all")
    List<Candidate> getAllCandidates(){
        return (List<Candidate>) candidateRepository.findAll();
    }

    @GetMapping
    Candidate getCandidate(@RequestParam Long id){
        Optional<Candidate> result = candidateRepository.findById(id);

        if (result.isEmpty()){
            return null;
        }

        return result.get();
    }

    @PostMapping
    Candidate addCandidate(@RequestBody Candidate proposedCandidate){
        //if (proposedCandidate.getId() == null) throw new IllegalArgumentException();
        Candidate candidate = candidateRepository.save(proposedCandidate);
        return candidate;
    }
}
