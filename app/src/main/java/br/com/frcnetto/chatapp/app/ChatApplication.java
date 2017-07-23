package br.com.frcnetto.chatapp.app;

import android.app.Application;

import br.com.frcnetto.chatapp.component.ChatComponent;
import br.com.frcnetto.chatapp.component.DaggerChatComponent;

/**
 * Created by frcnetto on 22/07/17.
 */

public class ChatApplication extends Application{
    private ChatComponent component;

    public void onCreate(){
        super.onCreate();
        component = DaggerChatComponent.builder().build();
    }

    public ChatComponent getComponent(){
        return component;
    }
}
