# API-Automation-Project
# Public API - https://dog.ceo/dog-api/
Instructions to run the REST API Project:
Save the projects in a desired location on your machine e.g Desktop
Open the command prompt
Change directory to point to where the projects are located e.g C:\...\Desktop\TASK1_APP
Run the program by using maven commands: > mvn clean
                                       : > mvn compile
                                       : > mvn test
After successfully running the tests, open the project to extract the report file:
Goto C:\...\Desktop\TASK1_APP\test-output
Right-click on a HTLM file called ExtentReportsTestNG.html, and select a desired browser

The performed calls are as stated below:
o Perform an API request to produce a list of all dog breeds.
o Using code, verify “retriever” breed is within the list.
o Perform an API request to produce a list of sub-breeds for “retriever”.
o Perform an API request to produce a random image / link for the sub-breed “golden”
