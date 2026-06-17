Feature: User Login

Background:
  Given User is in login page

Scenario: Successful admin login
  When Write valid admin username and password then presses the submit button
  Then Arrive at admin dashboard

Scenario: Successful branch login
  When Write valid branch account username and password then presses the submit button
  Then Arrive at branch dashboard

Scenario: Invalid credentials
  When Write invalid username and password then presses the submit button
  Then Stays at login page