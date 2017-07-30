package com.uitnetwork.alexa.speechlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.*;
import com.uitnetwork.alexa.config.SpringConfig;
import com.uitnetwork.alexa.service.SpeechletService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlexaJavaLamdaSpeechlet extends AbstractSpringAwareSpeechlet<SpringConfig> {

    private final SpeechletService speechletService;

    public AlexaJavaLamdaSpeechlet() {
        speechletService = applicationContext.getBean(SpeechletService.class);
    }

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
        log.info("Delegating to SpeechletService: {}", speechletService);

        speechletService.onSessionStarted(requestEnvelope);
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        return speechletService.onLaunch(requestEnvelope);
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        return speechletService.onIntent(requestEnvelope);
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
        speechletService.onSessionEnded(requestEnvelope);
    }
}
