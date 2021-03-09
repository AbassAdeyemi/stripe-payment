package com.hayba.stripepayments.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Getter @Setter
public class CreatePayment {

  @NotNull
  @Min(4)
  private Integer amount;

  @NotNull
  @Size(min = 5, max = 200)
  private String featureRequest;

}

