package com.example.demo.infrastructure.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(Include.NON_EMPTY)
public class PersonResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 4013604383803994035L;

  private final Integer id;
  private final String name;
  private final String surname;
  private final LocalDate dateOfBirth;
}
