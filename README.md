"# testvagrant"
Requirements:
JDK1.8+ , maven, eclipse with testNG configured
A) Instructions to run in eclipse:
1. Import the project in Eclipse
2. Build the project for importing dependecies from pom.xml
3. Right click on /src/test/resources/testXmlFiles/regressionTests.xml
4. From the options: Run As > TestNG Suite

B) Instructions to run with command line using maven
1. Launch cmd from project directory
2. Execute command: mvn clean test

Report generated in location: /src/test/resources/reports/TestAutomationReport.html