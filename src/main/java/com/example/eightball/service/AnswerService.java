package com.example.eightball.service;

import com.example.eightball.configuration.EightBallConfig;
import com.example.eightball.dto.EightBallRequest;
import com.example.eightball.dto.EightBallResponse;
import com.example.eightball.persistence.EightBallAnswerDocument;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class AnswerService {

  @Autowired
  private AnswerServiceDB answerServiceDB;

  @Autowired
  private EightBallConfig eightBallConfig;

  public EightBallResponse saveAnswer(EightBallRequest eightBallRequest) {

    EightBallResponse eightBallResponse = new EightBallResponse();
    eightBallResponse.setQuestion(eightBallRequest.getQuestion());

    Object[] answerTypes = eightBallConfig.getAnswers().keySet().toArray();
    Object answerType = answerTypes[new Random().nextInt(answerTypes.length)];
    List<String> answerValues = eightBallConfig.getAnswers().get(answerType);
    eightBallResponse.setAnswerType(answerType.toString());
    eightBallResponse.setAnswer(answerValues.get(new Random().nextInt(answerValues.size())));

    answerServiceDB.saveEightAnswerDoc(eightBallResponse);

    return eightBallResponse;
  }

}
