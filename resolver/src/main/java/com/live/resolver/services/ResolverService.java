package com.live.resolver.services;

import com.live.resolver.dtos.CompletedRoundDTO;

public interface ResolverService {

    //  Just turn a completed round into a resolved round

    String resolvedRound(CompletedRoundDTO completedRound);
}
