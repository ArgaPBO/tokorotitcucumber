Feature: Master User

Background:
  Given User is logged in as admin then opens users CRUD page

Scenario: Add new user valid
  When Press New User then enter valid user data then submit
  Then Get ✓ User created successfully message

Scenario: Add new user invalid
  When Press New User then press submit with fields empty
  Then Get Please fill required fields. Password required for new user. message