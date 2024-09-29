Feature: Is the SIM card activated?
  Verify that a SIM card activation is successful

  Scenario Outline: A SIM card may or may not be activated
    Given SIM card ICCID is "<iccid>"
    When I ask whether it's activated
    Then I should be told "<status>"

  Examples:
    | iccid                       | status |
    | 1255789453849037777         | true   |
    | 8944500102198304826         | false  |
