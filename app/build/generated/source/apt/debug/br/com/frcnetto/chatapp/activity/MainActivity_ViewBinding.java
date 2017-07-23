// Generated code from Butter Knife. Do not modify!
package br.com.frcnetto.chatapp.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import br.com.frcnetto.chatapp.R;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131558520;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.messagesList = Utils.findRequiredViewAsType(source, R.id.lv_messages, "field 'messagesList'", ListView.class);
    target.newMessage = Utils.findRequiredViewAsType(source, R.id.et_newmsg, "field 'newMessage'", EditText.class);
    view = Utils.findRequiredView(source, R.id.bt_send, "method 'sendMessage'");
    view2131558520 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sendMessage();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.messagesList = null;
    target.newMessage = null;

    view2131558520.setOnClickListener(null);
    view2131558520 = null;
  }
}
