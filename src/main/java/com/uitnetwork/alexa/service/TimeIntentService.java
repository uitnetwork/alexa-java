package com.uitnetwork.alexa.service;

import static com.uitnetwork.alexa.model.AlexaIntent.TIME_INTENT;
import static com.uitnetwork.alexa.util.AppConstants.SESSION_NAME;
import static java.lang.String.format;
import static java.time.LocalTime.now;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.uitnetwork.alexa.model.AlexaIntentRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TimeIntentService extends AlexaIntentRequestService {

    private static final ZoneId SINGAPORE_ZONE_ID = ZoneId.of("Asia/Singapore");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static final String TIME_MESSAGE = "It's <say-as interpret-as=\"time\">%s</say-as> in Singapore, %s";

    @Autowired
    private SpeechletResponseService speechletResponseService;

    @Override
    public SpeechletResponse doProcess(AlexaIntentRequest alexaIntentRequest) {
        Object sessionName = alexaIntentRequest.getIntentRequestEnvelope().getSession().getAttribute(SESSION_NAME);
        log.info("SessionName: {}", sessionName);
        String name = (String) sessionName;

        LocalTime currentTime = now(SINGAPORE_ZONE_ID);

        String ssmlMessage = format(TIME_MESSAGE, currentTime.format(TIME_FORMATTER), name);
        log.info("SSMLMessage: {}", ssmlMessage);

        return speechletResponseService.newTellResponse(ssmlMessage);
    }

    @Override
    public boolean canProcess(AlexaIntentRequest alexaIntentRequest) {
        return TIME_INTENT == alexaIntentRequest.alexaIntent;
    }
}
