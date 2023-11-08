package com.live.ongoing.messaging;

import com.live.ongoing.model.Round;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CompletedRoundPublisher {

    private final AmqpTemplate amqpTemplate;
    private final String roundExchange;
    public CompletedRoundPublisher(AmqpTemplate amqpTemplate, @Value("${amqp.exchange.round}") final String roundExchange){
        this.amqpTemplate = amqpTemplate;
        this.roundExchange = roundExchange;
    }

    public void sendMessage(Round roundToBeSent){

        CompletedRoundEvent event = buildEvent(roundToBeSent);

        String routingKey = "round." +
                 (event.isCompleted() ? "complete" : "incomplete") + "." + (event.isDuel() ? "duel" : "multi");

        amqpTemplate.convertAndSend(
                roundExchange,
                routingKey,
                event
        );
    }

    private CompletedRoundEvent buildEvent(Round roundToBeSent) {
        CompletedRoundEvent c = new CompletedRoundEvent(
                roundToBeSent.getId(),
                roundToBeSent.getDescription(),
                roundToBeSent.getCandidates().get(1L),
                roundToBeSent.getCandidates().get(2L),
                roundToBeSent.isDuel(),
                roundToBeSent.isComplete()
        );
        return c;
    }
}