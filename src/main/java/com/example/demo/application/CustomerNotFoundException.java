package com.example.demo.application;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.Serial;

public class CustomerNotFoundException extends NotFoundException {

  @Serial
  private static final long serialVersionUID = -4859745897388504910L;

  private static final String RESOURCE = "customer";

  public CustomerNotFoundException(final Integer id) {
    super(id, RESOURCE);
  }
}
