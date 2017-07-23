package br.com.frcnetto.chatapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.frcnetto.chatapp.R;
import br.com.frcnetto.chatapp.adapter.MessageAdapter;
import br.com.frcnetto.chatapp.app.ChatApplication;
import br.com.frcnetto.chatapp.callback.SendMessageCallback;
import br.com.frcnetto.chatapp.callback.UpdateMessagesCallback;
import br.com.frcnetto.chatapp.component.ChatComponent;
import br.com.frcnetto.chatapp.model.Message;
import br.com.frcnetto.chatapp.service.ChatService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lv_messages) protected ListView messagesList;
    @BindView(R.id.et_newmsg)   protected EditText newMessage;

    private List<Message>  messages;
    private MessageAdapter adapter;

    @Inject ChatService   service;
    private ChatComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
        initializeVars();

        ChatApplication app = (ChatApplication) getApplication();
        component = app.getComponent();
        component.infect(this);

        messagesList.setAdapter(adapter);
        setMessageListener();
    }

    @OnClick(R.id.bt_send)
    public void sendMessage(){
        service.sendMessage(
                new Message(1, newMessage.getText().toString()))
                .enqueue(new SendMessageCallback());
        newMessage.setText("");
    }

    private void initializeVars(){
        messages = new ArrayList<>();
        adapter = new MessageAdapter(messages, getApplicationContext());
    }

    public void updateMessageList(Message message){
        messages.add(message);
        MessageAdapter adapter = new MessageAdapter(messages, getApplicationContext());
        messagesList.setAdapter(adapter);
        setMessageListener();
    }

    public void setMessageListener(){
        Call<Message> call = service.messageListener();
        call.enqueue(new UpdateMessagesCallback(this));
    }
}
