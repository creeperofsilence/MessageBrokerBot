package MessageBot.Telegram_API;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

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
		String chatId = "-136404471";
		// String chatId= "-153295514";

		Integer updateId = 961087000;
		// SetWebhook request = new
		// SetWebhook().url("https://test.co.kr/").certificate(new byte[]{});
		// BaseResponse response = bot.execute(request);
		SendResponse sendResponse;

		// sendResponse = bot.execute(new SendMessage(chatId, "👍"));// +
		// update.message().text()));

		while (true) {

			Integer prevUpdateId = updateId;
			GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates().limit(10).offset(updateId).timeout(10));

			List<Update> updates = updatesResponse.updates();
			if (updates.size() > 0) {
				for (Update update : updates) {
					if (update.message().text() != null) {
						if (update.message().chat().id().toString().equals(chatId)) {
							
							if (update.message().text().contains("^^")) {
								//sendResponse = bot.execute(new SendMessage(chatId, "(진지)웃지마세요! "));// +
																									// update.message().text()));
								//updateId = update.updateId() + 1;
							} else if (update.message().text().contains("이돌람바")) {
								sendResponse = bot.execute(new SendMessage(chatId, "바람돌이"));// +
																							// update.message().text()));
								updateId = update.updateId() + 1;

							} else if (update.message().text().contains("때려줘여")) {
								sendResponse = bot.execute(new SendMessage(chatId, "때찌때찌맴매"));// +
																							// update.message().text()));
								updateId = update.updateId() + 1;
							}							
							else if (update.message().text().contains("옆자리")) {
								int value = (int) (Math.random() * (1 - 0 + 1));
								Path path = Paths.get("C:/local_mine/MessageBrokerBot/resources/image/" + value + ".jpg");
								// Path path =
								// Paths.get("C:/local_mine/MessageBrokerBot/resources/image/lee.jpg");
								byte[] data;
								try {
									data = Files.readAllBytes(path);
									sendResponse = bot.execute(new SendSticker(chatId, data));// +
																								// update.message().text()));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								updateId = update.updateId() + 1;
							} else if (update.message().text().contains("갓종성") || update.message().text().contains("종성갓")) {

								Path path = Paths.get("C:/local_mine/MessageBrokerBot/resources/image/sticker.webp");
								// Path path =
								// Paths.get("C:/local_mine/MessageBrokerBot/resources/image/lee.jpg");
								byte[] data;
								try {
									data = Files.readAllBytes(path);
									sendResponse = bot.execute(new SendSticker(chatId, data));// +
																								// update.message().text()));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								updateId = update.updateId() + 1;
							} else if (update.message().text().contains("님하")) {
								sendResponse = bot.execute(new SendMessage(chatId, "누구 부르냐? "));// +
																								// update.message().text()));
								updateId = update.updateId() + 1;
							} else if (update.message().text().contains("삼성")) {
								sendResponse = bot.execute(new SendMessage(chatId, "펑!!"));// +
																							// update.message().text()));
								updateId = update.updateId() + 1;
							} else if (update.message().text().contains("앙데")) {
								sendResponse = bot.execute(new SendMessage(chatId, "앙데르손?땅소나무ㅋㅋ"));// +
																									// update.message().text()));
								updateId = update.updateId() + 1;
							} else if (update.message().text().contains("ㅎㅇㅎㅇ")) {
								sendResponse = bot.execute(new SendMessage(chatId, "ㅎㄹㅎㄹ"));// +
																							// update.message().text()));
								updateId = update.updateId() + 1;
							} else if (update.message().text().contains("현기")) {
								sendResponse = bot.execute(new SendMessage(chatId, "안터져요"));// +
																									// update.message().text()));
								updateId = update.updateId() + 1;
							}	
//							} else if (update.message().text().contains("용재형")) {
//								sendResponse = bot.execute(new SendMessage(chatId, "내 나이가 어때서~~~"));// +
//																									// update.message().text()));
//								updateId = update.updateId() + 1;
//							} else if (update.message().text().contains("30대") || update.message().text().contains("내년")) {
//								java.util.Calendar cal = java.util.Calendar.getInstance(); // 일단
//																							// Calendar
//																							// 객체
//
//								int year = 2017; // 수능일 기준으로 잡아봤다.
//								int month = 01;
//								int date = 01;
//
//								long now_day = cal.getTimeInMillis(); // 현재 시간
//
//								cal.set(year, month - 1, date); // 목표일을 cal에 set
//
//								long event_day = cal.getTimeInMillis(); // 목표일에
//																		// 대한 시간
//								long d_day = (event_day - now_day) / (60 * 60 * 24 * 1000);
//
//								sendResponse = bot.execute(new SendMessage(chatId, "30대는 앞으로 한국 나이 " + d_day + "일,일본 나이 " + (d_day + 365) + "일 남았어요!"));// +								
//								updateId = update.updateId() + 1;
//							}
						}
					}
				}

				if (updateId.equals(prevUpdateId)) {
					updateId = updateId + updates.size();
				}

			}
		}
	}

	public boolean RunMethod(String str) {
		return str.equals("Test");
	}
}
