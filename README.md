# *Test Automation Framework* 

The framework was created in accordance with the tasks of the Epam Test Automation Summer School program. The main idea of the project is to cover  some elements with automated testing for [EPAM.UniversityProgram](https://training.epam.ua/#!/Home)


## ***How to set up and run***
---
1. You need to install Maven on your local machine
2. Clone current repository
```bash
git clone https://github.com/tsmichael/TA_SS_SELENIUM.git
```
3. Add your user data to `users_cred.json` file and place it in the `src/main/resources` folder. Use following scructure for appropriate workflow:
```JSON
{
    "valid":{
        "email": "valid-email",
        "password": "valid-password",
        "name": "valid-name"
    },
    "invalid":{
        "email": "invalid-email",
        "password": "invalid-password",
        "name": "invalid-name",
    }
}
```
4. Run tests with (default test-suite is `src/test/resources/testNg.xml`)

    ```bash
    mnv clean test
    ```

5. Generate report and run web-server with `allure-results`  
    ```
    mvn allure:serve
    ```



## ***Technologies***
---
+ Java
+ TestNG
+ Maven
+ Selenium WebDriver
+ Log4j
+ Jackson
+ Allure Reports




