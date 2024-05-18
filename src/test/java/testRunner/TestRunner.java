package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src\\test\\resources\\features"}, snippets = CucumberOptions.SnippetType.CAMELCASE, glue = {"stepDef"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
