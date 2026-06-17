Feature: Expense History

Background:
  Given User is logged in as branch user then opens expense history page

Scenario: Add new Expense History invalid
  When Press Add Single expense history then press submit with fields empty
  Then Get Please fill all required fields message for expense