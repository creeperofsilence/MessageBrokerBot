package MessageBot.Telegram_API;

import junit.framework.TestCase;

public class AppTest extends TestCase {

	public void testMain() {
		App app = new App();
		//app.main(null);
		//fail("Not yet implemented");
	}
	
	public void testRunMethod() {
		App app = new App();
		assertTrue(app.RunMethod("Test"));
	}

}
