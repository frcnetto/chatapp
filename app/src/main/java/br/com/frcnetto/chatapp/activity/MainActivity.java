package br.com.frcnetto.chatapp.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.frcnetto.chatapp.R;
import br.com.frcnetto.chatapp.adapter.MessageAdapter;
import br.com.frcnetto.chatapp.app.ChatApplication;
import br.com.frcnetto.chatapp.callback.UpdateMessagesCallback;
import br.com.frcnetto.chatapp.callback.SendMessageCallback;
import br.com.frcnetto.chatapp.component.ChatComponent;
import br.com.frcnetto.chatapp.model.Message;
import br.com.frcnetto.chatapp.service.ChatService;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    private ListView             messagesList;
    private List<Message>        messages;
    private MessageAdapter       adapter;
    private FloatingActionButton sendBtn;
    private EditText             newMessage;

    @Inject ChatService service;
    private ChatComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeVars();

        ChatApplication app = (ChatApplication) getApplication();
        component = app.getComponent();
        component.infect(this);

        messagesList.setAdapter(adapter);
        setMessageListener();
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.sendMessage(
                        new Message(1, newMessage.getText().toString()))
                        .enqueue(new SendMessageCallback());
                newMessage.setText("");
            }
        });
    }

    private void initializeVars(){
        messagesList = (ListView) findViewById(R.id.lv_messages);
        messages = new ArrayList<>();
        adapter = new MessageAdapter(messages, getApplicationContext());
        sendBtn = (FloatingActionButton) findViewById(R.id.bt_send);
        newMessage = (EditText) findViewById(R.id.et_newmsg);
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
