package br.com.frcnetto.chatapp.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import br.com.frcnetto.chatapp.activity.MainActivity;
import br.com.frcnetto.chatapp.model.Message;

/**
 * Created by frcnetto on 22/07/17.
 */

public class ChatService {
    private MainActivity mainActivity;

    public ChatService(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void sendMessage(final Message message){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String text = message.getText();
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL("http://192.168.0.53:8080/polling").openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("content-type", "application/json");

                    JSONStringer json = new JSONStringer()
                            .object()
                            .key("text")
                            .value(text)
                            .key("id")
                            .value(message.getId())
                            .endObject();

                    OutputStream stream = connection.getOutputStream();
                    PrintStream printStream = new PrintStream(stream);
                    printStream.println(json.toString());

                    connection.connect();
                    connection.getInputStream();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void messageListener(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL("http://192.168.0.53:8080/polling").openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept", "application/json");
                    connection.connect();

                    Scanner scanner = new Scanner(connection.getInputStream());
                    StringBuilder builder = new StringBuilder();

                    while (scanner.hasNextLine()){
                        builder.append(scanner.nextLine());
                    }

                    String json = builder.toString();

                    JSONObject jsonObject = new JSONObject(json);

                    final Message message = new Message(jsonObject.getInt("id"), jsonObject.getString("text"));

                    mainActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mainActivity.updateMessageList(message);
                        }
                    });
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
