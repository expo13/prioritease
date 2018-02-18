package expotek.com.prioritease;

import android.text.Layout;
import android.view.View;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Card;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaJustify;

import junit.framework.Test;


@LayoutSpec
public class BucketButtonSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c) {
        return Column.create(c)
                .alignItems(YogaAlign.CENTER)
                .justifyContent(YogaJustify.CENTER)
                .child(Card.create(c)
                        .cardBackgroundColorRes(R.color.colorPrimary)
                        .cornerRadiusDip(2)
                        .elevationDip(2)
                        .content(ButtonText.create(c).text("Button"))
                        .flexShrink(1)
                        .alignSelf(YogaAlign.CENTER))
                .clickHandler(BucketButton.onClick(c))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClick(ComponentContext c, @FromEvent View view,
                        @Prop OnButtonClickListener listener) {
        listener.onButtonClick();
    }

    interface OnButtonClickListener {
        void onButtonClick();
    }

}
