package com.example.eightball.persistence;

import java.time.Instant;
import java.util.UUID;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
public class EightBallAnswerDocument {

  @Id
  @Builder.Default
  private UUID id = UUID.randomUUID();

  @NonNull
  @Indexed
  private String question;

  @NonNull
  @Indexed
  private String answer;

  @NonNull
  @Indexed
  private String answerType;

  @Builder.Default
  private Instant created = Instant.now();
}
