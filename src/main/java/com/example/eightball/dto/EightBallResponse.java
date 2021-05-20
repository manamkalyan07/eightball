package com.example.eightball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EightBallResponse {
    private String question;
    private String answerType;
    private String answer;
}
