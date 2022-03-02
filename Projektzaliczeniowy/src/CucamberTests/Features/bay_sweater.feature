Feature: Buy product
  Scenario Outline: As a registered user i want to buy a product
    Given user is on a login site
    When user entered "<email>","<password>" and click sing in buttons
    And user click CLOTHES button
    And user click  on a Hummingbird Printed Sweater
    And user click size "<size>"
    And user add quantity "<quantity>"
    And user click ADD TO CART button
    And user click PROCEED TO CHECKOUT
    And user click proceed to checkout
    And user click Continue
    And user click second time continue
    And user click Pay by Check
    And user click check box
    And user click order with an obligation to pay
    And user is on Your order is confirmed take screen shot
    When user click signed user button
    And user click Order history and details
    Then user check status and price


    Examples:
      |email                       |password|size|quantity|
      |vjggnnnfbfidqfaefo@nvhrw.com|roman   |M   |5       |