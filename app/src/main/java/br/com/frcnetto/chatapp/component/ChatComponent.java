package br.com.frcnetto.chatapp.component;

import br.com.frcnetto.chatapp.activity.MainActivity;
import br.com.frcnetto.chatapp.module.ChatModule;
import dagger.Component;

/**
 * Created by frcnetto on 22/07/17.
 */
@Component(modules = ChatModule.class)
public interface ChatComponent {
    void infect(MainActivity activity);
}
