package expotek.com.PrioriTease;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.litho.Border;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.StateValue;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class MainLayoutSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(final ComponentContext c,
                                          @Prop String title,
                                          @Prop String desc,
                                          @Prop BucketButtonSpec.OnButtonClickListener listener) {

        Component titleString = Text.create(c, 0, R.style.TextAppearance_AppCompat_Title)
                .text(title)
                .typeface(Typeface.defaultFromStyle(Typeface.BOLD))
                .build();

        Component description = Text.create(c)
                .text(desc)
                .textSizeSp(17)
                .build();

        Component button = BucketButton.create(c).listener(listener).build();

        return Column.create(c)
                .child(titleString)
                .child(description)
                .child(button)
                .border(
                        Border.create(c)
                                .color(YogaEdge.ALL, Color.BLACK)
                                .widthDip(YogaEdge.ALL, 2)
                                .dashEffect(new float[]{10f, 5f}, 0f)
                                .build()
                )
                .build();

    }


}
