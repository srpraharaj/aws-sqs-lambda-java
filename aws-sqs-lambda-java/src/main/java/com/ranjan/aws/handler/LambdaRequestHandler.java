package com.ranjan.aws.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

public class LambdaRequestHandler implements RequestHandler<SQSEvent, String> {

	private static final Logger log = LoggerFactory.getLogger(LambdaRequestHandler.class);
	@Override
	public String handleRequest(SQSEvent input, Context context) {
		try {
			
			for(SQSEvent.SQSMessage message : input.getRecords()) {
				
				log.debug("SQS Message arrived - " + message.getBody());
			}
			
		}catch(Exception e) {
			log.error("Error while reading SQS message - " + e.getMessage());
		}
		return null;
	}

}
