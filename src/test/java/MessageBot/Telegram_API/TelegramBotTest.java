package MessageBot.Telegram_API;

import junit.framework.TestCase;

public class TelegramBotTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
		
	//bot과 1:1 채팅할 때 가져오는 메시지 API
	//api.telegram.org/bot<token>/getUpdates
	public void testGetUpdate() {
		
	}	
	
	//해당 채팅 아이디에서 나간다
	//api.telegram.org/bot<token>/leaveChat
	//Parameters
	//chat_id : 채팅 아이디
	public void testLeaveChat() {
		
	}
}
