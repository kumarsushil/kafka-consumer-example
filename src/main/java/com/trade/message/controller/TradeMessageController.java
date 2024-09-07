package com.trade.message.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trade.message.consumer.KafkaMessageListener;
import com.trade.message.dto.TradeMessage;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/consumer-app")
public class TradeMessageController {
	
	Logger log = LoggerFactory.getLogger(TradeMessageController.class);
	
	private final KafkaMessageListener kafkaMessageListener;

    @Autowired
    public TradeMessageController(KafkaMessageListener kafkaMessageListener) {
        this.kafkaMessageListener = kafkaMessageListener;
    }

    // Endpoint to get all messages consumed from Kafka
    @GetMapping("/kafka/messages")
    public List<TradeMessage> getMessages() {
        return kafkaMessageListener.getMessages();
    }
	/*
	 * @GetMapping(path = "/all") public ResponseEntity<TradeMessage>
	 * getAllTradeMessage(){ TradeMessage requiredResponse = new TradeMessage();
	 * requiredResponse = kafkaMessageListener.consumeMessage(requiredResponse);
	 * return new ResponseEntity<TradeMessage>(requiredResponse, HttpStatus.OK); }
	 */
	
	/*
	 * @GetMapping(path = "/all")
	 * 
	 * @KafkaListener(topics = "trade-message",groupId = "jt-group") public
	 * ResponseEntity<TradeMessage> consumeMessage2(TradeMessage tradeMessage) {
	 * log.info("consumer consume the events {} ", tradeMessage.toString());
	 * TradeMessage newMessage = tradeMessageWithDefualt(tradeMessage); return new
	 * ResponseEntity<TradeMessage>(newMessage, HttpStatus.OK); }
	 * 
	 * private TradeMessage tradeMessageWithDefualt(TradeMessage tradeMessage) {
	 * //Default TradeMessage with additional Security details information via find
	 * call TradeMessage newMessage = new TradeMessage("0134","Saving",
	 * "4473415","ISIN", "isin","check","check","check","check", 140,433.43); return
	 * newMessage; }
	 */
}
