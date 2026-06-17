Feature: Master Branch

Background:
  Given User is logged in as admin then opens Branchs CRUD page

Scenario: Add new Branch valid
  When Press New Branch then enter valid Branch data then submit
  Then Get Branch created successfully. message

Scenario: Add new Branch invalid
  When Press New Branch then press submit with fields empty
  Then Get Please enter a branch name message