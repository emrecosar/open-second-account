# Opening Secondary Accounts #
 
### To Run:

- Clone this repo to your local machine.
- Ensure you have Maven installed (https://maven.apache.org/download.cgi#Installation)
- Java 8
- From the main directory, run `mvn clean package`
- To run the program, use the following command:
`java -jar target/open-secondary-account-1.0.0-SNAPSHOT.jar`


### For Testing:
 
 - Application has embedded swagger-ui.
 - After running the application, open [swagger-ui](http://localhost:8081/swagger-ui.html) from browser.
 - You can see the end points
 - Just hit the APIs as you want.
 - While application is booting, some Customer and Account entities are pre-installed (5 customer[ids are 1...5] has one account[ids are 1...5] each other) If you want to change initial set, go to Application class.
 
## Copying ##

Copyright (C) 2018 Emre Cosar