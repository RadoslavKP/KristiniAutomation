package pages;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.SerializationFeature;
import org.example.Formatters;
import org.example.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AxeAccessibilityPage {
    private final WebDriver webDriver;
    private final AxeBuilder axeBuilder;
    private final Formatters formatters;

    private static final String REPORT_DIR = "target/accessibility-reports/";
    private static final String RAW_JSON_FILE = REPORT_DIR + ".json";
    private static final String FORMATTED_JSON_FILE = REPORT_DIR + "formatted-axe-results.json";

    public AxeAccessibilityPage() {
        this.webDriver = WebDriverFactory.getWebDriver();
        this.axeBuilder = new AxeBuilder();
        this.formatters = new Formatters();
    }

    public void generateAxeFullPageReport() {
        AxeReporter.writeResultsToJsonFile(REPORT_DIR, axeBuilder.analyze(webDriver));
        formatters.formatJson(RAW_JSON_FILE, FORMATTED_JSON_FILE);
        // Currently the scan return a Json file in the automation project.
        // There is no support by deque yet for a Java Json -> HTML report
        // I will try to create a custom logic in a later phase for it, but for now its just Json ;p
    }

    public void scanCurrentPageForViolationsWithAxe() {
        Results axeResults = axeBuilder.analyze(webDriver);
        List<Rule> violations = axeResults.getViolations();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty-print JSON
            mapper.writeValue(new File(REPORT_DIR + "/violations.json"), violations);
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatters.formatJson(RAW_JSON_FILE, FORMATTED_JSON_FILE);
    }

}
