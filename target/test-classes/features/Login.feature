@test
Feature: Login scenarios

  Scenario Outline: Login with invalid user name
    Given I'm in login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on Login button
    Then login should fail with an error "<err>"
    Examples:
      | username        | password     | err |
      | notvaliduser    | secret_sauce | Provided credentials do not match any user in this service. |
      | invalidUsername | secret_sauce | Provided credentials do not match any user in this service. |

  Scenario Outline: Login with invalid user password
    Given I'm in login page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on Login button
    Then login should fail with an error "<err>"
    Examples:
      | username        | password     | err |
      | notvaliduser    | secret_sauce | Provided credentials do not match any user in this service. |
      | invalidUsername | secret_sauce | Provided credentials do not match any user in this service. |
