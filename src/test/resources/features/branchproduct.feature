Feature: Master Product

Background:
  Given User is logged in as branch user then opens branch products page

Scenario: Add new Branch Product invalid
  When Press Add Branch Product then press submit with fields empty
  Then Get Please select a product and enter branch price message