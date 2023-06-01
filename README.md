# rest-assured-testng project ⛩️

This project focuses on API testing using RestAssured for the Swagger Petstore API. It utilizes Maven as the build automation tool. The purpose of this project is to ensure the functionality and reliability of the API by performing various test scenarios.

## How to run
To get started with this project, follow the steps below:

1. Clone the repository to your local machine
2. Run the entire test suite using Maven:
 ```
 mvn clean test
 ```
3. To run a specific test, you can use the TestNG annotations and specify the test class. For example, if you want to run the **CreatePet** test, you can use the following command:
```
mvn clean test -Dtest=CreatePet
```
Replace **CreatePet** with the desired tag for the specific test you want to run.


### 📚 TestNG Report
This project uses TestNG as the testing framework, generating a HTML report after test execution in the **/target/surefire-reports** directory. The report includes detailed information on test results, such as test case status, execution time, and any failures or errors encountered
