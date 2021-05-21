package com.example.eightball.controller;

import com.example.eightball.dto.EightBallRequest;
import com.example.eightball.dto.EightBallResponse;
import com.example.eightball.persistence.EightBallAnswerDocument;
import com.example.eightball.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {

  @Autowired
  private AnswerService answerService;

  // TODO: Add an endpoint to return an answer to a question

  @PostMapping("/eightBallAnswer")
  public EightBallResponse saveAnswer(@RequestBody EightBallRequest eightBallRequest){
    return answerService.saveAnswer(eightBallRequest);
  }

  @GetMapping("/fetchAnswers")
  public List<EightBallAnswerDocument> getAllSavedAnswers(){
    return answerService.getAllSavedAnswer();

  }

}
