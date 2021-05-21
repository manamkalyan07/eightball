package com.example.eightball.service;

import com.example.eightball.dto.EightBallResponse;
import com.example.eightball.persistence.EightBallAnswerDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceDB {

    @Autowired
    private MongoTemplate mongoTemplate;


    public void saveEightAnswerDoc(EightBallResponse eightBallResponse) {
        EightBallAnswerDocument eightBallAnswerDocument = new EightBallAnswerDocument();
        eightBallAnswerDocument.setQuestion(eightBallResponse.getQuestion());
        eightBallAnswerDocument.setAnswerType(eightBallResponse.getAnswerType());
        eightBallAnswerDocument.setAnswer(eightBallResponse.getAnswer());
        mongoTemplate.save(eightBallAnswerDocument);

    }
}
