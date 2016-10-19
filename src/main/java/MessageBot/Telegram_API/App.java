package MessageBot.Telegram_API;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		TelegramBot bot = TelegramBotAdapter.build(BotConfig.BOT_TOKEN);
		String chatId = "-136404471";
		Integer updateId = 961085875;
		//SetWebhook request = new SetWebhook().url("https://test.co.kr/").certificate(new byte[]{});
		//BaseResponse response = bot.execute(request);						
		SendResponse sendResponse;
		
		while (true) {
			GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates()
					.limit(10).offset(updateId).timeout(0));

			List<Update> updates = updatesResponse.updates();
			if (updates.size() > 0) {
				for (Update update : updates) {
					if (update.message().text() != null) {
						if (update.message().text().contains("ㅋㅋ")) {
							sendResponse = bot.execute(new SendMessage(chatId,
									"(진지)웃지마세요! "));// + update.message().text()));
							updateId = update.updateId() + 1;
						}
						else if (update.message().text().contains("용재")) {
							sendResponse = bot.execute(new SendMessage(chatId,
									"잠수 타지말고 나오셈! "));// + update.message().text()));
							updateId = update.updateId() + 1;
						}
						else if (update.message().text().contains("갓종성")) {
							sendResponse = bot.execute(new SendMessage(chatId,
									"찬양하라!^^ "));// + update.message().text()));
							updateId = update.updateId() + 1;
						}
					}
				}
			}
		}
	}

	public boolean RunMethod(String str) {
		return str.equals("Test");
	}
}
