package org.example;

import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public MyBot() {
        // super("тут ваш токен, що зренерував для вас BotFather");
        super("7696117913:AAFhdTsHpBsA1KotvtUluh8IKwaRAMCke34");
    }

    @Override
    public void onUpdateReceived(Update update) {
        var chatId = update.getMessage().getChatId();
        var text = update.getMessage().getText();

        try {
            var message = new SendMessage();
            message.setChatId(chatId);

            if (text.equals("/start")) {
                message.setText("Привіт, Ольга)))!");
            } else if (text.equals("btc")) {
                var price = CryptoPrice.spotPrice("BTC");
                message.setText("BTC price: " + price.getAmount().doubleValue());
            } else if (text.equals("eth")) {
                var price = CryptoPrice.spotPrice("ETH");
                message.setText("ETH price: " + price.getAmount().doubleValue());


            } else if (text.equals("all")) {
                var price_BTC = CryptoPrice.spotPrice("BTC");
                var price_ETH = CryptoPrice.spotPrice("ETH");
                var price_DOGE = CryptoPrice.spotPrice("DOGE");
message.setText("Надаю всю інформацію: " +
        "BTC price: " + price_BTC.getAmount().doubleValue() +
      "; ETH price: " + price_ETH.getAmount().doubleValue() +
      "; DOGE price: " + price_DOGE.getAmount().doubleValue()
);}
        else if (text.equals("6000")) {
            var price_BTC = CryptoPrice.spotPrice("BTC");
            var price_ETH = CryptoPrice.spotPrice("ETH");
            var price_DOGE = CryptoPrice.spotPrice("DOGE");
            message.setText(
                    "BTC price: " + price_BTC.getAmount().doubleValue() * 6000 +
                  "; ETH price: " + price_ETH.getAmount().doubleValue() * 6000 +
                  "; DOGE price: " + price_DOGE.getAmount().doubleValue()* 6000
            );

            } else {
                message.setText("Unknown command!");
            }

            execute(message);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    @Override
    public String getBotUsername() {
        return "ProgAcademyOlga_bot";
    }
}
