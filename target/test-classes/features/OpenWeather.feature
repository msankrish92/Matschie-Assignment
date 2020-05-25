Feature: Open weather app

Scenario Outline: TC001_Get city weather by name

Given enable logs and set appId and <CityName>
When send request as get
Then the status code is 200 and response time less than 10000
And print includes the following

Examples:
|CityName|
|Chennai|
|London|
|Delhi|
|Bangalore|