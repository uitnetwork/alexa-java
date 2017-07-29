package com.uitnetwork.alexa.speechlet;


import java.lang.reflect.ParameterizedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.speech.speechlet.SpeechletV2;

public abstract class AbstractSpringAwareSpeechlet<T> implements SpeechletV2 {
    private static final Logger logger = LoggerFactory.getLogger(AbstractSpringAwareSpeechlet.class);

    protected final ApplicationContext applicationContext;

    public AbstractSpringAwareSpeechlet() {
        Class<T> typeParameterClass = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        applicationContext = new AnnotationConfigApplicationContext(typeParameterClass);

        logger.info("Created {} instance: {}.", this.getClass().getSimpleName(), this);
    }
}
