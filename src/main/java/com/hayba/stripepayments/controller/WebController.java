package com.hayba.stripepayments.controller;

import com.hayba.stripepayments.form.CheckoutForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class WebController {

  @Value("${stripe.public.key}")
  private String stripePublicKey;

  @GetMapping("/checkout")
  public String checkout(Model model) {
    model.addAttribute("stripePublicKey", stripePublicKey);
    return "checkout";
  }

  @PostMapping("/checkout")
  public String checkout(@ModelAttribute @Valid CheckoutForm checkoutForm, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors())
      return "index";

    model.addAttribute("stripePublicKey", stripePublicKey);
    model.addAttribute("amount", checkoutForm.getAmount());
    model.addAttribute("email", checkoutForm.getEmail());
    model.addAttribute("featureRequest", checkoutForm.getFeatureRequest());
    return "checkout";
  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("checkoutForm", new CheckoutForm());
    return "index";
  }
}
