Feature: Login functionality

  Background:
    Given navigate to the website

    Scenario: correct username wrong password
      And enter your username<"standard_user">
      And enter the wrong password<"123">
      And click login button
      Then verify the error message

      Scenario: Wrong username right password
        And enter your username<"faruk">
        And enter the wrong password<"secret_sauce">
        And click login button
        Then verify the error message

        Scenario: What if username is not passed in?
          And enter your username<"">
          And enter the wrong password<"secret_sauce">
          And click login button
          Then verify the error message

          Scenario: What if password is not passed in?
            And enter your username<"standard_user">
            And enter the wrong password<"">
            And click login button
            Then verify the error message
