package com.uitnetwork.alexa.handler;

import static com.uitnetwork.alexa.util.AppConstants.SUPPORTED_APP_ID;
import static java.util.Arrays.asList;

import java.util.HashSet;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.uitnetwork.alexa.speechlet.HelloWorldSpeechlet;

public class HelloWorldHandler extends SpeechletRequestStreamHandler {

    public HelloWorldHandler() {
        super(new HelloWorldSpeechlet(), new HashSet<String>(asList(SUPPORTED_APP_ID)));
    }
}
