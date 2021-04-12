Feature: Smoke
  I want to test all main site functional
  So that I can be sure that site works correctly

  Scenario Outline: Check Error MyAccount
    Given User opens '<homePage>'
    When User hover over MyAccount icon
    And User clicks MyAccount link
    And User clicks SignIn CTA
    Then User checks that EmptyEmail error is shown
    And User checks that EmptyPassword error is shown
    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |

  Scenario Outline: Check Possibility To Proceed To Checkout
    Given User opens '<homePage>'
    When User hover over Accessories button on Navigation menu
    And User clicks on Bags link
    And  User clicks on Product Tile on Bags PLP
    And User clicks on Add To Bag Button
    And User clicks on Checkout Link On MiniCart DropDown
    Then User checks that checkout Page header is '<header>'
    Examples:
      | homePage                    | header   |
      | https://www.asos.com/women/ | CHECKOUT |

  Scenario Outline: Check Delete Product From Cart
    Given User opens '<homePage>'
    And User checks Search Field is visible
    When User enter '<keyword>' into Search Field
    And User clicks Search Button
    And  User clicks on Add To Bag Button
    And User clicks on Bag link on MiniBag DropDown
    And User checks My Bag Page header is visible
    And User clicks Remove icon on My Bag Page
    Then User checks that Bag Page Title is '<title>'
    Examples:
      | homePage                    | keyword  | title             |
      | https://www.asos.com/women/ | 24155441 | Your bag is empty |

  Scenario Outline: Check Selecting Size on PDP
    Given User opens '<homePage>'
    And User checks Search Field is visible
    When User enter '<keyword>' into Search Field
    And User clicks Search Button
    And User clicks on SelectSize DropDown
    And User clicks on Size Option
    And User clicks on Add To Bag Button
    And User clicks on Bag link on MiniBag DropDown
    And User checks My Bag Page header is visible
    Then User checks that Size Option on MyBag Page is the same as on PDP
    Examples:
      | homePage                    | keyword  |
      | https://www.asos.com/women/ | 23378411 |

  Scenario Outline: Check Save for Later on My Bag Page
    Given User opens '<homePage>'
    And User checks Search Field is visible
    When User enter '<keyword>' into Search Field
    And User clicks Search Button
    And  User clicks on Add To Bag Button
    And User clicks on Bag link on MiniBag DropDown
    And User clicks on Save for later button on MyBag Page
    And User checks that Empty Bag title is visible
    And User clicks on Saved Items Icon
    And User checks Saved Items Page Title is visible
    And User clicks on Move To Bag Button
    Then User checks that MiniBag Items Count is '<itemsCount>'
    Examples:
      | homePage                    | keyword  | itemsCount |
      | https://www.asos.com/women/ | 24155441 | 1          |

  Scenario Outline: Check Free Delivery Information on MiniBag DropDown
    Given User opens '<homePage>'
    And User checks Search Field is visible
    When User enter '<keyword>' into Search Field
    And User clicks Search Button
    And  User clicks on Add To Bag Button
    And User clicks on Free Delivery Link On MiniBag Footer
    Then User checks that current url contains '<urlKeyword>' word
    Examples:
      | homePage                    | keyword  | urlKeyword |
      | https://www.asos.com/women/ | 24155441 | delivery   |

  Scenario Outline: Check navigation though Content pages
    Given User opens '<homePage>'
    When User clicks on Help Link On Footer
    And User checks Search For Help Field is Visible
    And User enter '<keyword>' into Search For Help Field
    And User clicks on search For Help Button
    And User checks that Search Header contains Text '<keyword>'
    And User click on Return Something To You Tab
    And User checks that Return Something ToYou Header is Visible
    And User clicks on View Your Returns Options Link
    Then User checks that current url contains '<keyword>' word
    Examples:
      | homePage                    | keyword |
      | https://www.asos.com/women/ | returns |

  Scenario Outline: Check Breadcrums navigation
    Given User opens '<homePage>'
    When User hover over Accessories button on Navigation menu
    And User clicks on Bags link
    And  User clicks on Product Tile on Bags PLP
    And User clicks on  Bags Breadcrums Link
    Then User checks that current url contains '<urlKeyword>' word
    Examples:
      | homePage                    | urlKeyword  |
      | https://www.asos.com/women/ | bags-purses |

  Scenario Outline: Check buying Gift Voucher
    Given User opens '<homePage>'
    When User clicks Gift Vouchers Link On Footer
    And User checks Gift Vouchers Title contains '<titleText>'
    And User enters '<valueText>' into Voucher Value Field
    And User enters '<emailText>' into Voucher Email Field
    And User enters '<nameText>' into Voucher Name Field
    And User clicks  Pay Securely Now Button
    Then User checks that checkout Page header is '<header>'
    Examples:
      | homePage                    | titleText     | valueText | emailText                  | nameText | header   |
      | https://www.asos.com/women/ | GIFT VOUCHERS | 50        | qualitydandelion@gmail.com | Quality  | CHECKOUT |

  Scenario Outline: Check changing currency
    Given User opens '<homePage>'
    When User clicks on select Country Icon;
    And User clicks on select Currency Field
    And User clicks on Euro Option
    And User clicks on updatePreferencesCTA
    And User checks Search Field is visible
    When User enter '<keyword>' into Search Field
    And User clicks Search Button
    Then User checks that Price component on PDP contains '<currencySign>'
    Examples:
      | homePage                    | keyword  | currencySign |
      | https://www.asos.com/women/ | 24155441 | €            |
