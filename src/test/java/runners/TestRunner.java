package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features="src/test/resources/features",
    dryRun=false,
    glue={"stepdefs"},
    plugin={"pretty"},
    tags="@Sample"
    
)
public class TestRunner extends AbstractTestNGCucumberTests{

}

