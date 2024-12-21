# TravelSiteAutomation

to execute features in parallel

-> mvn test

to execute scenarios in parallel 

-> update in pom.xml info.cukes dependencies with io.cucumber dependencies, and update TestRunner class to getScenarios()

1. Can be integrated with any report portal using TestNG listeners
2. Framework can be extended to other functionalities of the website by creating new page objects, features and step definitions.
3. Cucumber reports are generated using CucumberOptions in TestRunner class. It has good GUI representation.
4. There are tags for @Sanity and @Regression. Specify the tag to be executed in TestRunner Cucumber Options
