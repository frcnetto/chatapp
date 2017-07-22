package br.com.frcnetto.chatapp.callback;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by frcnetto on 22/07/17.
 */

public class SendMessageCallback implements retrofit2.Callback<Void> {
    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {

    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {

    }
}
