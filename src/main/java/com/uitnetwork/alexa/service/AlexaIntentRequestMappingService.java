package com.uitnetwork.alexa.service;

import static com.uitnetwork.alexa.model.AlexaIntent.lookupAlexaIntent;

import org.springframework.stereotype.Service;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.uitnetwork.alexa.model.AlexaIntent;
import com.uitnetwork.alexa.model.AlexaIntentRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlexaIntentRequestMappingService {

    public AlexaIntentRequest translate(SpeechletRequestEnvelope<IntentRequest> intentRequestEnvelope) {
        log.info("Mapping for intentName: {}", intentRequestEnvelope.getRequest().getIntent().getName());

        AlexaIntent alexaIntent = lookupAlexaIntent(intentRequestEnvelope.getRequest().getIntent().getName());
        return new AlexaIntentRequest(alexaIntent, intentRequestEnvelope);
    }
}
