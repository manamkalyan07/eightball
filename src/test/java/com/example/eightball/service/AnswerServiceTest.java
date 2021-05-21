package com.example.eightball.service;

import com.example.eightball.configuration.EightBallConfig;
import com.example.eightball.dto.EightBallRequest;
import com.example.eightball.dto.EightBallResponse;
import com.example.eightball.persistence.EightBallAnswerDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AnswerServiceTest {


  @Autowired
  private AnswerService answerService;

  @Test
  public void testAnswer() {
    EightBallRequest mockEightBallRequest = new EightBallRequest();
    mockEightBallRequest.setQuestion("Future ??");
    EightBallResponse eightBallResponse = answerService.saveAnswer(mockEightBallRequest);
    assertSame(eightBallResponse.getQuestion(),mockEightBallRequest.getQuestion());
    assertNotNull(eightBallResponse.getAnswer());
    assertNotNull(eightBallResponse.getAnswerType());

  }
}
