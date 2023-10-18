package dungeongame.mapandfindingitems;

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

        if (x == 0) {
            switch (y) {
                case 0:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mjN2YYhKB5WaEeYywK2jEDSZyP-o5Fw-uFYktAMDIrbcxBG4C57VH8AzrPMMRl22P6MSMjiLFIQaRnFrEE7npMidbi0wvzugmFmoDYk7zeGcPUv_dY0HYxf1KJMihmKf68B-HeY0FwMxoG7ADst-muoNRHdF6awC89DJYcisrefm5ZabCxE8jQZFZxPejci1R7p9E8fnI2IfGAb5gy3K7WUL48bKBAoOTF7vJoBTUviY?encodeFailures=1&width=327&height=331"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mfRPtsyA-YSLrdf22Nx76Cv76sB_goCzPrcKiYsuLpqeV51qnL2vFMUMpKMS1cVk2UKJ0ukP8-9WGwRGktrbsy4abXu0eTvTc8sWPe_tudarJP3U1C0_9glS1JdioP2xFH91P_5wRui5NTLMKipND1qxrO8erQy2K32Fpj1_NuLr6jWnK963ESd_SAxjoXTj7qbUEGtkQQUOqHRQEDa-DyK0FkMaXCbBX2Vq6xfooqCA?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mtUC1h69qWX3MChj5jX75RiFVxyHYdZwAGZ2_tsxFp7GeTZDIEVx3GrW3pNHRPeIe1P98pwKVoZEcyaG9jAPQXkRleyI5axUJoTEdblUlbNpSrsWXopvPVvHl_fOT6pOErifTTHEbW0xN5Yu75l7rY9Bw4_fQOTMtsT8HyM3rdTsdu0PUCnXxcccLSpB4cxyuZJ63exEp9yfBLoKXo0K7tCoR-SCS2srqP6JfrqnhTw0?encodeFailures=1&width=341&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } else if (x == 1) {
            switch (y) {
                case 0:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mU6ADmGO_mwdBw1MFKrzUiKkcQpnsZGzNhDzV7Z8aIcOUtLp85UVmq5xTp2SDJ4KVDkLkMybVVVitwzTH9JsR8ZzxlApY-flqka3i_SsKUyF0lQjYzpKTDcfuF__hH42vbm-1d_O-QF0gvZJuWZpiG2_U_OD0lsHuBJzZp-Bxvbue4g3MOYOxSJHyrx4VlLZP6HY7EqtUjSCdqoqkefqL1p1NtjHTquLhPrmigbnXLD4?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4moTB_Eq9r1jYBGIrSAd8b6eh4fDToVAfDNcANvKpyvCdhHAeaYtTi9iGpEF26jJnAlkVqXqPX5LAkjZEVl1v-0kWYO56N4C6A1vOROybGc2ybMi_LQRs6ZLG5gBBtEauv2P2n2OIai0lewSK6Bz2eMubH5T_WaQ-fFKE8ZbBxa9kcwQ45GUywrS-yRKZQk0-j-PeCxgPJ-gHX2U0s1gd__7RpNrF-w5xtDyWGU4LowKE?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mWYYqvrs4zzbsqqOxZO5g3UmAaK9KTUjQDGnHDE1m02I39sIDQAGXPnUkCgjMTgx3ui3XSHxbs0AiuaJ_-nYS1savlRJ9pyudijD8cINYEEK8dFdlF8LWFJNAwxzxfoN7qtOfZU_r6bYp_GpZVXbSeW3WCe5gORnYTmdOOQ77kmIUYs4U7YL_dUlS5agwekygQSZ-nxlaGcEMvoBFN_fxLHP-xSPIJWMgGn0ql0Qkpa4?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }

        } else if(x == 2) {
            switch (y) {
                case 0:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mWuKwC_MNw6n55WA1vqjXuFXS5oPKO7StTowZ2TvVuoFxfmeLo0rrsEDG9IQSWscubC7ibYJinSiyL1G-MqUlQiRnKG10fTfO0kYJKfPwtRzuZ5Bl6sw5Mydz7g6tT5shOfQl9veBczkdvPwxMzNll3zWDpY3IPwmhLPGgORj7QNEGb73t56GK84N-maA9HJA5OP8UWBZo96QmwWt78aix_4YowE2wDKLpWO-5WMCvW8?encodeFailures=1&width=330&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4m5a22kTdtAzxYBemeNZ9y3rTvoW0OYLYjiD7CQC_ClPCMQ7kU-VF-lRqNGm_HBWGbJykfsY8FwKFtxSbmpXd86qRJ1gJfqCh0asLhHCAQtwDehUG3Ekt9NxPcBActvJpfEAswhhrlS7LMHdj3Wcx8EOGWaxyN7YD_AnOVojt4RvSr4B7CP5V3QsyumcASthLyUaYqbIIHZr-dGnhjSGDGP8HubGiXr9jxPcNyVGdTe5s?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    sendPhoto.setPhoto(new InputFile("https://db3pap006files.storage.live.com/y4mBCu8p6WKy4YI7RMOZ6ZHQYRm7rvjKWgmwdjIaWtjFtv93uUx5pE3UekKbAVEt-hF3bWy6_5MaqGheflDSHGQMZkJ1Gj9lrysEvZmp7gYeWVk0NpefnO_Mx5txGJCyxN9s6MtFp3249TuPIq19w8EEqq9BVKkOQheNh0DAT6LCRnHxhL5bqKLvXeWEHeJJZVBpBf1ebij1mQNbeXdm1W2FVw9EcCsfnAAJuXf0-QLK0o?encodeFailures=1&width=327&height=330"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }


    }
}
