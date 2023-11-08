package com.live.ongoing.services;

import com.live.ongoing.messaging.CompletedRoundPublisher;
import com.live.ongoing.model.Round;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OngoingRoundServiceImpl implements OngoingRoundService{



    public final CompletedRoundPublisher completedRoundPublisher;

    @Override
    public String test() {
        return "Service Test";
    }

    @Override
    public String completeRound() {

        Round round = new Round();

        completedRoundPublisher.sendMessage(round);

        return "Nothing so far";
    }
}
