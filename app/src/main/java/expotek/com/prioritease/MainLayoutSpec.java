package expotek.com.prioritease;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;

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
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaPositionType;

import java.util.List;


@LayoutSpec
public class MainLayoutSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(final ComponentContext c,
                                          @Prop List<Bucket> bucketList,
                                          @Prop String title,
                                          @Prop BucketButtonSpec.OnButtonClickListener listener) {

        Component titleString = Text.create(c, 0, R.style.TextAppearance_AppCompat_Title)
                .text(title)
                .textSizeDip(18)
                .typeface(Typeface.defaultFromStyle(Typeface.BOLD))
                .textAlignment(Layout.Alignment.ALIGN_CENTER)
                .build();


        Component list =
                RecyclerCollectionComponent.create(c)
                        .disablePTR(true)
                        .backgroundColor(Color.GREEN)
                        .alpha((float) .5)
                        .flexGrow(1)
//                        .border( Border.create(c)
//                                .color(YogaEdge.ALL, Color.RED)
//                                .widthDip(YogaEdge.ALL, 2)
//                                .build())
                        .section(BucketList.create(new SectionContext(c)).bucketList(bucketList).listener(listener).build())
                        .heightDip(360)
                        .build();

        Component floatingButton = FloatingButton.create(c)
                .positionType(YogaPositionType.ABSOLUTE)
                .heightDip(40)
                .widthDip(40)
                .build();

        return Column.create(c)
                .child(titleString)
                .child(list)
                .child(floatingButton)
                .backgroundColor(Color.GREEN)
                .alpha((float) .4)
//                .border(
//                        Border.create(c)
//                                .color(YogaEdge.ALL, Color.BLACK)
//                                .widthDip(YogaEdge.ALL, 2)
//                                .dashEffect(new float[]{10f, 5f}, 0f)
//                                .build()
//                )
                .build();

    }


}
