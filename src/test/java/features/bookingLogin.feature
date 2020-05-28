
@LoginPage
Feature: Booking.com User Login

Background:
   Given Initiate the driver and open browser
    And Navigate to booking.com

  @HomePageTest
  Scenario: Positive test User loging
    Given Initiate the driver and open browser
    And Navigate to booking.com
    And Click "Signin" button on the home page
    When User enters 'userEmail' and 'password'
    Then Verify User is successfully logged in

  @userAccountTest
  Scenario Outline: Negative test User login
    Given Initiate the driver and open browser
    And Maximize window
    And Navigate to mail.ru
    When User enters wrong <username> and <password>
    Then catch error message displaying error

    Examples: 
      | username             | password |
      | testing123@gmail.com |   123456 |
      | testing321@gmail.com |   654321 |

      
      