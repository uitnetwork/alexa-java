package com.uitnetwork.alexa.handler;

import static com.uitnetwork.alexa.util.AppUtils.getSupportedAppIds;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.uitnetwork.alexa.speechlet.AlexaJavaLamdaSpeechlet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlexaJavaLamdaHandler extends SpeechletRequestStreamHandler {

    public AlexaJavaLamdaHandler() {
        super(new AlexaJavaLamdaSpeechlet(), getSupportedAppIds());

        log.info("Created AlexaJavaLamdaHandler instance: {}", this);
    }
}
