package com.uitnetwork.alexa.service;

import static org.slf4j.LoggerFactory.getLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.*;
import com.uitnetwork.alexa.model.AlexaIntentRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SpeechletService implements SpeechletV2 {

    @Autowired
    private IntroductionService introductionService;

    @Autowired
    private AlexaIntentRequestMappingService alexaIntentRequestMappingService;

    @Autowired
    private AlexaIntentRequestManager alexaIntentRequestManager;

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
        log.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(), requestEnvelope.getSession().getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        log.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(), requestEnvelope.getSession().getSessionId());
        return introductionService.createIntrodutionSpeechletResponse(requestEnvelope);
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        log.info("onIntent requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(), requestEnvelope.getSession().getSessionId());

        AlexaIntentRequest alexaIntentRequest = alexaIntentRequestMappingService.translate(requestEnvelope);
        return alexaIntentRequestManager.process(alexaIntentRequest);
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
        log.info("onSessionEnded requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(), requestEnvelope.getSession().getSessionId());
    }
}
