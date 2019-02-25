Feature: Logging in Gmail and deleting 3 important messages

  Background:
    Given I'm a Gmail user

  Scenario Outline: Logging in Gmail
    When I have logging page in Gmail
    Then I enter <mail> and press button next
    Then I enter <password>
    And Press button Next for password
    Examples:
      | mail                       | password      |
      | autohelp.lviv@gmail.com    | 13101998gmail |
      | testng.userdrive@gmail.com | 1111test      |
      | selenium.test337@gmail.com | Qwerty333     |

  Scenario: Deleting 3 important messages
    When I have home page in Gmail
    Then I check 3 message as important
    Then I check 3 message using the CheckBox
    And Press button "Delete"
    Then I check is messages is deleted

