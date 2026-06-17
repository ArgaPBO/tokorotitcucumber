Feature: Master Expense

Background:
  Given User is logged in as admin then opens expense CRUD page

Scenario: Add new expense valid
  When Press Add Expense then enter valid expense data then submit
  Then Get Expense created successfully. message

Scenario: Add new expense invalid
  When Press Add Product then press submit with fields empty
  Then Get Please enter an expense name message