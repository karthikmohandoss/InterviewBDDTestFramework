Feature: Submission of the data

  @formsubmission @regression
  Scenario Outline: Validate the submission of form as success when enter with valid values
    Given I open the application form
    And I validate the page title as "Web form"
    When I enter all the details as below in the Web form
      | Field Name           | Values                 |
      | Text Input           | <Text Input>           |
      | Password             | <Password>             |
      | Text Area            | <Text Area>            |
      | Dropdown Select      | <Dropdown Select>      |
      | Dropdown Datalist    | <Dropdown Datalist>    |
      | Upload File          | <File Name>            |
      | Checked checkbox     | <Checked checkbox>     |
      | Default checkbox     | <Default checkbox>     |
      | Default Radio Button | <Default Radio Button> |
      | Color picker         | <Color picker>         |
      | Date picker          | <Date picker>          |
      | Example Range        | <Example Range>        |
    And I assert the state of the input field is set to disabled
    And I assert the state of the read only field is set to read only
    And I click on the submit button
    Then a message "Received!" will be displayed

    Examples:
      | Text Input            | Password      | Text Area       | Dropdown Select | Dropdown Datalist | File Name | Checked checkbox | Default checkbox | Default Radio Button | Color picker | Date picker | Example Range |
      | Automation Test One   | TestPassOne   | Text area One   | One             | Seattle           | testfile  | Uncheck          | Check            | Check                | #ff5733      | 01/12/2025  | Right         |
      | Automation Test Two   | TestPassTwo   | Text area Two   | Two             | San Francisco     | testfile  | Uncheck          | Check            | Check                | #ffbd33      | 12/01/2025  | Left          |
      | Automation Test Three | TestPassThree | Text area Three | Three           | New York          | testfile  | Uncheck          | Check            | Check                | #dbff33      | 30/05/2025  | Right         |