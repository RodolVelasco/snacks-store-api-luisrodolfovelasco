# snacks-store-api-luisrodolfovelasco
Snacks Store | Products and Purchases Rest API built for a technical challenge in a recruitment process using Spring Boot.
# Requirements
For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Spring Tool Suite](https://spring.io/tools3/sts/all)
- [Postman](https://www.getpostman.com/downloads/canary)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
# Running the application locally
There are several ways to run a Spring Boot application on your local machine. Since recruiters need to review the code, below you will find how to clone this repository, mount it and deploying it in Spring Tool Suite (STS)

1. Open STS
2. Go to "Quick Access" textbox and type "git". Select "Git repositories (Git)
3. Once "Git repositories" tab is open, select "Clone a repository" link
4. Once a window is opened, in URI textfield paste this link "https://github.com/RodolVelasco/snacks-store-api-luisrodolfovelasco.git"
5. Click "Next", then select "master" branch and click "Finish"
6. Go to "Package Explorer" and right click, select "Import" and then select "Existing Maven Project. Go to the folder file location where you download the clone in step 4 (git folder). Then navigate and select the project's folder git/snacks-store-api-luisrodolfovelasco/snacks-store-api-luisrodolfovelasco
7. Wait until dependiencies download
8. Right click in project's name and go to "Run as", then go to "Maven" and select "Maven build". Type "clean install" in "Goals" textfield
9. Wait to see a message that says "BUILD SUCCESS",
10. In "src/main/resources/application.properties" file, type database user and password credentials
11. Ensure MySQL is up and running
12. Import postman collection from this link (https://www.getpostman.com/collections/b2d79b66a0bfd98f8571)
13. Right click in project's name, select "Run as" and then "Spring Boot Application"
## Authors
* Rodolfo Velasco
