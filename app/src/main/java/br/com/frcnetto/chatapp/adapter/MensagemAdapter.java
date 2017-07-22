package br.com.frcnetto.chatapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.frcnetto.chatapp.model.Mensagem;

/**
 * Created by frcnetto on 21/07/17.
 */

public class MensagemAdapter extends BaseAdapter {

    private List<Mensagem> mensagens;

    public MensagemAdapter(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    @Override
    public int getCount() {
        return mensagens.size();
    }

    @Override
    public Object getItem(int i) {
        return mensagens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
