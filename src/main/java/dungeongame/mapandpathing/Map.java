package dungeongame.mapandpathing;

import dungeongame.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Map extends Bot {

// je nachdem an welcher Position der User ist, wird eine andere Karte ausgegeben
    public void showMap(Long chatId, int x, int y) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        if (x == 0){
            switch (y){
                case 0:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mqzYEGqD3eAKJuQSG2CkoTaK_YyHpKwf1bIUGuTX-taPrji6etpoj6O0V0xBHYULefC5hfCm5Hz9I6wVas6ToAOIjwHiuleVFIHnzPv2xh90kpLW6_JT-vYknnr8kHa4yAxOoauoM-ObKmVQdqKduCE4DgIub1-4YzJjTePZZzB9Ok8LyqQ8HPgT7Aj8fjcgWWsCa8xyAHFECyUVcXrtVo2ZMqpdG-6QW56tTbQtwL-w?encodeFailures=1&width=327&height=331"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mR6wjwD88DP_cZw0iB7X7JRYiza5o5cnLif0c7zliCutRsTF56X41TQoIwrTkf4OFKbFQawkqa298NhidkoHGWBHueFfsctyTpNm2-szvO-sNdlxE9zIKY6Xa9fddRqOGpmWL_3aDXYMSg4Il4mFwXQZQj2gwX6jVZkrGMK4bEXO2hp3_Cy2EVWVxPiOnQ_eYjwm_irlt0G-h8WpGhhy6sdV1kIY6h6HTBAtQQGu4rjY?encodeFailures=1&width=341&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    sendMessage.setText("Dieses Abenteuer ist noch nicht freigeschaltet, aber es gibt auch hier viel zu entdecken!");
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

            }
        } else if (x == 1) {
            switch (y){
                case 0:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mOYyvCPnF6LNEc8WthIN0VcuEtbxHifPOt42gLq9wMm4w70vR_AzPrtpi2vwhik-BG0wl75IkBHqrh6PbdE8DOTxZxh8wNEi01tk1t8g7HvoKf155WsQqwuUTVa9Wd_xQdpksqSE0HUqiL9LCTgkNlDvaNpHPtz9n-txga7yX7Y7oBFf_u35OL10XD-6aEOGEywB2dyLZjr-QgfDRaARC8WyRmhePj6M-GNDR8vTde5Y?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4m_gAxwuXXzUHp-JfkdmvhjqRdvz2KugwJ8SAWENiv6yKNf7dfwHA43ze-8K7bp6Cnb2dkqyRitEMjD-s8oso33aPYjIQepRq2azYNlX1MQ_z1cKa53gnhA2QUYNnrJkC6v1YoCGwJw-dcYxsq1CS9EMOIwIqsLq4klMGyFvkNgzMlj4nzjYazZUbnQJaa5GmSyggo1YnRLWdZ9S7JiYdDKLgAtihZCj7vZmZB-eP2xTY?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mBKxx8bqew-UOlGVLPMVk09I_lzhoSrcCNJUauv_ZUTXpp4IFDx9Z78xZPTDVyGTYNO6QMJBXFs28p2sb1L7mCxKrW_aVdx2oRFPkFiTK6EvN2g080nlA-YfPqLz2RiqljdeJJzpjWgyeOisj6KmMb9M63xjiZTNGCcpWS-e5qgnqIfipRUBdNhh1DHPhKFY-5KrlApQZat9rZYASr78RNkto7HXxXZizARTeeoa4v04?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    sendMessage.setText("Dieses Abenteuer ist noch nicht freigeschaltet, aber es gibt auch hier viel zu entdecken!");
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

            }

        }else if (x == 2){
            if (y == 0) {
                sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4m2FFQ9HUkJQaH8e2ektYkmWlRhQl443KSKDXbscZTYesXAvznhAL4gpt-Ss3AtcV1CU9OWW54dSd-ryJpMCiG744aRW2ChUFE8HkW-NyhBaga42VSsksqCcTcYzU7aBwtxVzzW5Vg2k6_hfFswviAiYU_8dTcZxqpPvpyNE7i9ytW78_JMO6HBTCcA0invaDf_2-tEFx6UnFrN1-LjD4z4wfHH4zjNSpazHibLY004Qs?encodeFailures=1&width=330&height=330"));
                try {
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                sendMessage.setText("Dieses Abenteuer ist noch nicht freigeschaltet, aber es gibt auch hier viel zu entdecken!");
                try {
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
