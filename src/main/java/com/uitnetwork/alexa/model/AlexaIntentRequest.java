package com.uitnetwork.alexa.model;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import lombok.Data;

@Data
public class AlexaIntentRequest {
    public final AlexaIntent alexaIntent;

    public final SpeechletRequestEnvelope<IntentRequest> intentRequestEnvelope;
}
