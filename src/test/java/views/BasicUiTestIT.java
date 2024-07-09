package views;

import com.example.application.Application;
import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.testbench.BrowserTest;
import com.vaadin.testbench.BrowserTestBase;
import com.vaadin.testbench.annotations.RunLocally;
import com.vaadin.testbench.parallel.Browser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.test.context.SpringBootTest;

@Execution(ExecutionMode.SAME_THREAD)
@SpringBootTest(classes = {Application.class})
@RunLocally(Browser.CHROME)
public class BasicUiTestIT extends BrowserTestBase {

	@BeforeEach
	protected void setUp() {

		getDriver().get("http://localhost:8080");
		getCommandExecutor().waitForVaadin();
	}

	@BrowserTest
	void testButtonText() {
		ButtonElement button = $(ButtonElement.class).first();
		Assertions.assertEquals("TEST", button.getText());
	}
}
