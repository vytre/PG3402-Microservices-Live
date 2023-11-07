package com.live.resolver.services;
import com.live.resolver.dtos.CompletedRoundDTO;
import com.live.resolver.model.ResolvedRound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SimplestResolverServiceImpl implements ResolverService{
    @Override
    public ResolvedRound resolveRound(CompletedRoundDTO completedRound) {
        return resolveRoundRandom(completedRound);
    }

    public ResolvedRound resolveRound(CompletedRoundDTO completedRound, double dieRoll){
        ResolvedRound round = new ResolvedRound(
                null,
                completedRound.getId(),
                completedRound.getCandidateA(),
                completedRound.getCandidateB(),
                completedRound.getDescription(),
                "Unresolved"
        );

        if (dieRoll < 0.5) {
            round.outcome = completedRound.getCandidateA() + " won";

        }else {
            round.outcome = completedRound.getCandidateB() + " won";
        }
        return round;
    }


    public ResolvedRound resolveRoundRandom(CompletedRoundDTO completedRound){
        Random random = new Random();
        double number = random.nextDouble();

        return resolveRound(completedRound, number);
    }
}
