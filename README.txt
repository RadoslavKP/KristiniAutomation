Hello and welcome to the Test Automation project.
The target of the automation is the http://kristini-bg.com/ website.
The website does not have that many functionalities ,but the idea is to create an Regression set
of tests that cover most of the functionalities during testing.
-------------------------------------------------------------------------------------------------------
This would be helpful for people who wonder how does an Automation Project in a company conditions looks
like.
We are using Java + Selenium + Cucumber.
For Project Management Tools we are using - Maven.
With Maven I have selector the TestNG library.
The idea is to integrate Jenkins as an CI/CD tool (Which means we will use Jenkins to automate the
run cycle of the project itself) but currently that is not yet implemented.
Other further ideas are to use RestAPI to create some API Automation test, but again that will be done
in the near future.
I would try also to create an TestRun is TestRail and link the automation TCs to TCs in TestRail.
With this integration + Jenkins we would be able to have a Automation TestRun which auto-updates the
TCs results under the TestRail run (As used in many companies over the world)
--------------------------------------------------------------------------------------------------------
Information in regards the Project Structure:
Automation\src\test\java\stepDefinitions
Here we create the steps definitions (Gherkin + Java Code).
Automation\src\test\resources\features
Here we store the features files, Placeholder.feature file is the one that is used to Test
newly implemented steps/TCs.
Automation\src\test\java\runners
Here we store the MainRunner class which is used to configure CucumberOptions
(Runtime options - such as Console output versions, reporting to HTML file)
Automation\src\main\java\modules
Here we store the module classes of the project, the modules are linked with steps defined in StepDefinitions
class from above.
Automation\src\main\java\pages
Here we store the page classed of the project, the pages are linked to the steps defined in modules
In short we have the following linkage:
Create a new Gherkin Step in the Placeholder -> Define the step in the StepDefinitions.class ->
Link the defined step to a new method in a module class -> Link the module method toward page method->
Under page we create the Java Code in regards what should the step be doing

Example code in page:
   public void verifyGalleryPage() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        assertTrue(webDriverFactory.isElementDisplayed(GALLERY_PAGE));
    }

When executed the verifyGalleryPage verifies that an element is displayed on the Chromedriver screen.
--------------------------------------------------------------------------------------------------------
If you have any questions, feel free to contact me on GitHub - https://github.com/RadoslavKP


