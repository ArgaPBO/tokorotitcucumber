Feature: Master Product

Background:
  Given User is logged in as admin then opens products CRUD page

Scenario: Add new product valid
  When Press New Product then enter valid product data then submit
  Then Get Product created successfully. message
  And New product data is visible in the table

Scenario: Add new Branch invalid
  When Press New Product then press submit with fields empty
  Then Get Please enter name and price message