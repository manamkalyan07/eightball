package com.example.eightball.service;

import com.example.eightball.dto.EightBallResponse;
import com.example.eightball.persistence.EightBallAnswerDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceDB {

    @Autowired
    private MongoTemplate mongoTemplate;


    public EightBallResponse saveEightAnswerDoc(EightBallAnswerDocument eightBallAnswerDocument) {
        mongoTemplate.save(eightBallAnswerDocument);
        EightBallResponse eightBallResponse = new EightBallResponse();
        eightBallResponse.setQuestion(eightBallAnswerDocument.getQuestion());
        eightBallResponse.setAnswerType(eightBallAnswerDocument.getAnswerType());
        eightBallResponse.setAnswer(eightBallAnswerDocument.getAnswer());
        return eightBallResponse;

    }

    public List<EightBallAnswerDocument> getAllSavedAnswer() {
        return mongoTemplate.findAll(EightBallAnswerDocument.class);
    }
}
