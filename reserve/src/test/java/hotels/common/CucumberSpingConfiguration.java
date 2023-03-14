package hotels.common;

import hotels.ReserveApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ReserveApplication.class })
public class CucumberSpingConfiguration {}
