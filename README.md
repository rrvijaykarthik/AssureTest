1.The following steps helps you to run the project in local repository once you clone the project.

2.Feature file "ValidateGetAPI.feature" under Feature folder is a cucumber file which helps to understand test case from a user perspective.The user inputs 1.Name,2.CanRelist,3.ProName,4.ProDescription are the user inputs which are checked against the JSON output generated out of GET Request. Additional combination of input can be added to check if the test case is passed/failed.

3.To run the project go to src/test/java ,under RunnerClass package, please run the TestRunner.java as junit.

4.Once the project is run for eight input combinations present in "ValidateGetAPI.feature", go to folder "test-output"->HtmlReport->ExtentHtml.html and open with a webapplication such as MicrosoftEdge or Chrome for checking the extent report to check the total no of test case, total passed , total failed etc.
