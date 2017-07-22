package br.com.frcnetto.chatapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.frcnetto.chatapp.R;
import br.com.frcnetto.chatapp.model.Message;
import br.com.frcnetto.chatapp.viewholder.MessageViewHolder;

/**
 * Created by frcnetto on 21/07/17.
 */

public class MessageAdapter extends BaseAdapter {

    private List<Message> messages;
    private Context       context;

    public MessageAdapter(List<Message> messages, Context context) {
        this.messages = messages;
        this.context  = context;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        MessageViewHolder holder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
            holder = new MessageViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = new MessageViewHolder(view);
        }

        Message message = (Message) getItem(position);
        holder.texto.setText(message.getText());

        if (message.getId() != 1)
            holder.texto.setBackgroundColor(view.getResources().getColor(R.color.md_blue_grey_900));

        return view;
    }
}

