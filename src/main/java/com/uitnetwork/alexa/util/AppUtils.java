package com.uitnetwork.alexa.util;

import static com.uitnetwork.alexa.util.AppConstants.ENV_VARIABLE_SUPPORTED_APP_IDS;
import static com.uitnetwork.alexa.util.AppConstants.SUPPORTED_APP_ID_SEPERATOR;
import static java.lang.System.getenv;
import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppUtils {


    public static final Set<String> getSupportedAppIds() {
        String supportedAppIdsString = getenv(ENV_VARIABLE_SUPPORTED_APP_IDS);

        String[] supportedAppIdArray = supportedAppIdsString.split(SUPPORTED_APP_ID_SEPERATOR);
        HashSet<String> supportedAppIds = new HashSet<>(asList(supportedAppIdArray));

        log.info("Supported App Ids are: {}", supportedAppIdsString);
        return supportedAppIds;
    }
}
