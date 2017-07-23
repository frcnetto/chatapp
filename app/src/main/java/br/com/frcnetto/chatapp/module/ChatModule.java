package br.com.frcnetto.chatapp.module;

import br.com.frcnetto.chatapp.service.ChatService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by frcnetto on 22/07/17.
 */

@Module
public class ChatModule{
    @Provides
    public ChatService getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.53:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ChatService.class);
    }

}
