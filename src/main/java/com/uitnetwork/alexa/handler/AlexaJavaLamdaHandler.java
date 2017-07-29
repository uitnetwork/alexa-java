package com.uitnetwork.alexa.handler;

import static com.uitnetwork.alexa.util.AppUtils.getSupportedAppIds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.uitnetwork.alexa.speechlet.AlexaJavaLamdaSpeechlet;

public class AlexaJavaLamdaHandler extends SpeechletRequestStreamHandler {
    private static final Logger logger = LoggerFactory.getLogger(AlexaJavaLamdaSpeechlet.class);

    public AlexaJavaLamdaHandler() {
        super(new AlexaJavaLamdaSpeechlet(), getSupportedAppIds());

        logger.info("Created HelloWorldHandler instance: {}", this);
    }
}
