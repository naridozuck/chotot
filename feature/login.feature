Feature: Login testing
 @login
  Scenario: TC1 - User login successfully
    Given User login with username "${u_username}" and password "${p_password}"
#    Then User login successfully and name display