package com.example.eightball.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("eightball")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EightBallConfig {
    private Map<String, List<String>> answers = new HashMap<>();
}
