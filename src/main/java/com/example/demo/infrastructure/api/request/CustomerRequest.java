package com.example.demo.infrastructure.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
public class CustomerRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = 614015548881635883L;

  private Integer id;

  @Valid
  @NotNull(message = "THIS_FIELD_IS_MANDATORY_MESSAGE")
  private PersonRequest person;

  private String reference;

}
