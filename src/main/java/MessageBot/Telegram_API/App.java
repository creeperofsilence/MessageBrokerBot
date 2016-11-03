package MessageBot.Telegram_API;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendSticker;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		TelegramBot bot = TelegramBotAdapter.build(BotConfig.BOT_TOKEN);
		String chatId = "111111";
		// String chatId= "-153295514";
		String host = "127.0.0.1";
		int port = 1234;
		Integer updateId = 961090980;
		// SetWebhook request = new
		// SetWebhook().url("https://test.co.kr/").certificate(new byte[]{});
		// BaseResponse response = bot.execute(request);
		SendResponse sendResponse;

		// sendResponse = bot.execute(new SendMessage(chatId, "👍"));// +
		// update.message().text()));

		while (true) {

			JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "host", port);
			Jedis jedis = jedisPool.getResource();

			Map<String, String> chats = jedis.hgetAll("lastestId");

			for (String chat : chats.keySet()) {
				updateId = Integer.valueOf(chats.get(chat).toString());
				Integer prevUpdateId =  updateId;
				GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates().limit(5).offset(updateId).timeout(20));

				List<Update> updates = updatesResponse.updates();
				if (updates.size() > 0) {
					for (Update update : updates) {
						if (update.message().text() != null) {
							if (update.message().chat().id().toString().equals(chatId)) {

								Map<String, String> map = jedis.hgetAll("hashlist2");

								for (String key : map.keySet()) {
									if (update.message().text().contains(key)) {
										sendResponse = bot.execute(new SendMessage(chatId, map.get(key)));
										updateId = update.updateId() + 1;
										jedis.hset("lastestId", chatId.toString(), updateId.toString());
										System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
									}
								}
							}
						}
					}

					if (updateId.equals(prevUpdateId)) {
						updateId = updateId + updates.size();
						jedis.hset("lastestId", chatId.toString(), updateId.toString());
					}

				}
			}
			
			if (null != jedis) {
				jedis.close();
			}

		}
	}

	public boolean RunMethod(String str) {
		return str.equals("Test");
	}
}
