package expotek.com.prioritease;

import android.graphics.Color;
import android.graphics.Typeface;
import com.facebook.litho.Border;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.widget.Text;
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

        final Component list =
                RecyclerCollectionComponent.create(c)
                        .disablePTR(true)
                        .section(BucketList.create(new SectionContext(c)).build())
                        .build();

        return Column.create(c)
                .child(titleString)
                .child(description)
                .child(list)
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
