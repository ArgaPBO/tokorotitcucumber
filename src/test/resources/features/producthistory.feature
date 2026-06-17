Feature: Product History

Background:
  Given User is logged in as branch user then opens product history page

Scenario: Add new Product History invalid
  When Press Add Single product history then press submit with fields empty
  Then Get Please fill all required fields message