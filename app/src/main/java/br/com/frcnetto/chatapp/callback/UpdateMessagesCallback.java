package br.com.frcnetto.chatapp.callback;

import br.com.frcnetto.chatapp.activity.MainActivity;
import br.com.frcnetto.chatapp.model.Message;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by frcnetto on 22/07/17.
 */

public class UpdateMessagesCallback implements Callback<Message> {
    MainActivity activity;

    public UpdateMessagesCallback(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(Call<Message> call, Response<Message> response) {
        Message message = response.body();
        activity.updateMessageList(message);
    }

    @Override
    public void onFailure(Call<Message> call, Throwable t) {
        activity.setMessageListener();
    }
}
