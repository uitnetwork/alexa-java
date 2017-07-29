package com.uitnetwork.alexa.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

class SpringConfigTest {

    @Test
    public void shouldHaveConfigurationAnnotation() {
        Configuration configuration = findAnnotation(SpringConfig.class, Configuration.class);
        assertThat(configuration).isNotNull();
    }


    @Test
    public void shouldHaveComponentScanAnnotation() {
        ComponentScan componentScan = findAnnotation(SpringConfig.class, ComponentScan.class);

        assertThat(componentScan).isNotNull();
        assertThat(componentScan.value()).contains("com.uitnetwork.alexa");
    }
}
