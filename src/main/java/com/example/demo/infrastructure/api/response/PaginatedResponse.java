package com.example.demo.infrastructure.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(Include.NON_EMPTY)
public class PaginatedResponse<T> implements Serializable {

  @Serial
  private static final long serialVersionUID = 5994122034100114192L;

  private final Integer total;
  private final Integer page;
  private final Integer size;
  private final List<T> items;
}
