package de.facemirrored.appschattenzorn.rest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

  private static final long serialVersionUID = 7882664102310081185L;

  private String businessErrorMessage;

  private String technicalErrorMessage;
}
