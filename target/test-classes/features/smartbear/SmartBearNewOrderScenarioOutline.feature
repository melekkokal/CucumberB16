Feature: Testing New Order Functionality for Smart Bear
  Scenario Outline: Happy Path for Creating New Order On Smart Bear
    Given User types 'Tester' and 'test'
    When User clicks order button and picks product '<product>' and enters '4'
    Then User types '<name>' , '<street>' , '<city>' , '<state>' '<zipcode>' for address info
    And User clicks on '<card>' and enters '<cardnumber>' and '<expirationdate>'
    Then User click process button and validates '<message>' and clicks view all orders
    Then User validates all info '<name>','<product>>','<quantity>','<date>','<street>','<city>','<state>','<zipcode>','<card>','<cardnumber>','<expirationdate>'
    Examples:
    |name|street|city|state|zipcode|cardnumber|expirationdate|message|product  |card|quantity|date|
    |Melek|123 Mel St     |Melville|ML|77777|11111111|06/25|New order has been successfully added.|MyMoney       |Visa      |4     |06/25/2023|
    |Havva|345 H Ct       |Hville  |HC|11111|11111111|07/26|New order has been successfully added.|FamilyAlbum   |MasterCard|5      |06/26/2023 |
    |Buket|987 B Pl       |Bcille  |BK|22222|11111111|08/27|New order has been successfully added.|ScreenSaver   |American Express|9 |06/25/2023|