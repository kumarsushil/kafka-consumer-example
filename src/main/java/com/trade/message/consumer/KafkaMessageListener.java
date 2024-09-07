package com.trade.message.consumer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.trade.message.dto.TradeMessage;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

	/*
	 * @KafkaListener(topics = "trade-message",groupId = "jt-group") public
	 * TradeMessage consumeMessage(TradeMessage tradeMessage) {
	 * log.info("consumer consume the events {} ", tradeMessage.toString()); return
	 * tradeMessage; }
	 */
    
 // Store messages consumed from Kafka
    private final List<TradeMessage> messages = new ArrayList<>();

    // Kafka Listener for a specific topic
    @KafkaListener(topics = "trade-message",groupId = "jt-group")
    public void listen(TradeMessage tradeMessage) {
    	 log.info("consumer consume the message {} ", tradeMessage.toString());      
        synchronized (tradeMessage) {
            messages.add(tradeMessage);
        }
    }

    // Return all consumed messages
    public List<TradeMessage> getMessages() {
        synchronized (messages) {
            return new ArrayList<>(messages);
        }
    }

    // Clear stored messages (optional method)
    public void clearMessages() {
        synchronized (messages) {
            messages.clear();
        }
    }

}
