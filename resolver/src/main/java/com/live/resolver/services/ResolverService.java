package com.live.resolver.services;

import com.live.resolver.dtos.CompletedRoundDTO;
import com.live.resolver.model.ResolvedRound;

public interface ResolverService {
    // Just turn a completed round into a resolved round
    ResolvedRound resolveRound(CompletedRoundDTO completedRoundDTO);
}
