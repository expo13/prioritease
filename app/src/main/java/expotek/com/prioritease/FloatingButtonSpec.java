package expotek.com.prioritease;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
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
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaJustify;

@MountSpec
public class FloatingButtonSpec {

    @OnCreateMountContent
    static Drawable onCreateMountContent(ComponentContext c) {
        return c.getDrawable(android.R.drawable.ic_dialog_email);
//        return new FloatingActionButton(c);
    }

//    @OnCreateLayout
//    static ComponentLayout onCreateLayout(ComponentContext c) {
//        return Column.create(c)
//                .alignItems(YogaAlign.FLEX_END)
////                .justifyContent(YogaJustify.FLEX_END)
//                .child(Card.create(c)
//                        .cardBackgroundColorRes(R.color.colorPrimary)
//                        .cornerRadiusDip(10)
//                        .elevationDip(2)
//                        .content(Text.create(c).text("+").textSizeDip(20))
//                        .flexShrink(1)
//                        .alignSelf(YogaAlign.CENTER))
////                .clickHandler(BucketButton.onClick(c))
//                .border(
//                        Border.create(c)
//                                .color(YogaEdge.ALL, Color.BLACK)
//                                .widthDip(YogaEdge.ALL, 2)
//                                .dashEffect(new float[]{10f, 5f}, 0f)
//                                .build()
//                )
//                .build();
//    }

//    @OnEvent(ClickEvent.class)
//    static void onClick(ComponentContext c, @FromEvent View view,
//                        @Prop BucketButtonSpec.OnButtonClickListener listener) {
//        listener.onButtonClick();
//    }
//
//    interface OnButtonClickListener {
//        void onButtonClick();
//    }

}
