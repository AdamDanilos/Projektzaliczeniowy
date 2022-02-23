package nicelook;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/Add_new_address.feature",
        plugin = {"pretty", "html:out/report.html"}
)

public class reports {
}
