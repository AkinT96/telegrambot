package dungeongame.Basiccommands;

import dungeongame.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class VoiceSender {
    public static SendVoice createSoundEffect(Long chatId) {
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId(chatId);
        sendVoice.setCaption("Spiel mich ab");
        sendVoice.setVoice(new InputFile("https://public.db.files.1drv.com/y4mRWoNdgN8x17sIGeKlg1mTkPEKDv2STGZuOQ2Ut5Kl0RzoNi2LyzrtzcSIPyuAXGUVXQjj6mVVfHdOqnyvKPO_0ElLosRqhanRnoUdccd-1_9ZuMSz3hpR7ZCdYe-Q1TY40es7mH62gZAyhbP-I_TR6IhgAApCYc_qEJWx_pKWhJaeSNwmoY64A5_3jNn9Z03bt36RsmtQbyOkoQT9IweQmzjUdI7mNAQSFLa1HoESOM?AVOverride=1"));
        return sendVoice;
    }

    public static void sendVoice(Bot bot, SendVoice sendVoice) {
        bot.setVoiceFlag(false);
        try {
            bot.execute(sendVoice);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
