package br.com.frcnetto.chatapp.viewholder;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.frcnetto.chatapp.R;

public class MessageViewHolder {
    public final TextView texto;

    public MessageViewHolder(View view){
        texto = view.findViewById(R.id.et_message);
    }
}
