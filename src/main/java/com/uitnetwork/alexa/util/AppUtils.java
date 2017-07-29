package com.uitnetwork.alexa.util;

import static java.lang.System.getenv;
import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppUtils {
    private static final Logger logger = LoggerFactory.getLogger(AppUtils.class);

    public static final String ENV_VARIABLE_SUPPORTED_APP_IDS = "SUPPORTED_APP_IDS";
    private static final String SUPPORTED_APP_ID_SEPERATOR = ",";

    public static final Set<String> getSupportedAppIds() {
        String supportedAppIdsString = getenv(ENV_VARIABLE_SUPPORTED_APP_IDS);

        String[] supportedAppIdArray = supportedAppIdsString.split(SUPPORTED_APP_ID_SEPERATOR);
        HashSet<String> supportedAppIds = new HashSet<>(asList(supportedAppIdArray));

        logger.info("Supported App Ids are: {}", supportedAppIdsString);
        return supportedAppIds;
    }
}
