package com.live.ongoing.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OngoingRoundServiceImpl implements OngoingRoundService{
    @Override
    public String test() {
        return "Service Test";
    }

    @Override
    public String completeRound() {
        return "Nothing so far";
    }
}
