package br.com.frcnetto.chatapp.service;

import br.com.frcnetto.chatapp.model.Message;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by frcnetto on 22/07/17.
 */

public interface ChatService {

    @POST("polling")
    Call<Void> sendMessage(@Body Message message);

    @GET("polling")
    Call<Message> messageListener();
}
