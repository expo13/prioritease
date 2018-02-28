package expotek.com.prioritease.views;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.facebook.litho.Border;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaJustify;

import expotek.com.prioritease.R;

@MountSpec
public class FloatingButtonSpec {

    @OnCreateMountContent
    static Drawable onCreateMountContent(ComponentContext c) {
        return c.getDrawable(R.drawable.circle_add);
    }



    @OnEvent(ClickEvent.class)
    static void onClick(ComponentContext c, @FromEvent View view
//,                        @Prop FloatingButtonSpec.OnButtonClickListenerFloatingButton listener) {
    ){
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        Log.d("TAG", "You're It!");
//         listener.onFloatingButtonClick();
    }

    public interface OnButtonClickListenerFloatingButton {
        void onFloatingButtonClick();
    }

}
