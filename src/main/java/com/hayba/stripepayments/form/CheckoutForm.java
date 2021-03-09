package com.hayba.stripepayments.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class CheckoutForm {
    @NotNull
    @Min(4)
    private Integer amount;
    @NotNull
   @Size(min = 5, max = 200)
    private String featureRequest;
    @Email
    private String email;
}
