Feature: Testing New Order Functionality for Smart Bear
  Scenario: Happy Path for Creating New Order On Smart Bear
    Given User types 'Tester' and 'test'
    When User clicks order button and picks product 'MyMoney' and enters '4'
    Then User types 'Melek' , '123 Mel St' , 'Melville' , 'ML' '77777' for address info
    And User clicks on 'Visa' and enters '11111111' and '06/25'
    Then User click process button and validates 'New order has been successfully added.' and clicks view all orders
    Then User validates all info 'Melek','MyMoney','4','06/25/2023','123 Mel St','Melville','ML','77777','VISA','11111111','06/25'