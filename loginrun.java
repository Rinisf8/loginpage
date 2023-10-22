package saucedemo.crunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/afeatures",
        glue = "saucedemo.bstepdef"
)

public class loginrun {
}
