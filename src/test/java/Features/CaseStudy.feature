Feature: Alerts ( handle all alerts)

  Background:
    Given Navigate to Website


    Scenario: Alerts test
      And click Alerts and Frame windows
      And click alerts
      And click first alert and verify
      And  verify second alert  will appear in five seconds
      And  click the third and confirm box will appear
      And click the forth and verify the prompt box will appear

      Scenario: interactions
        And click interactions
        And click droppable menu
        And verify the item is draged and droped

        Scenario: Widgets
          And click widgets
          And click tool tips and verify the messages








