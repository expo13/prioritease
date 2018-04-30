package expotek.com.prioritease.views;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.sections.widget.RecyclerCollectionComponentSpec;
import com.facebook.litho.sections.widget.RecyclerCollectionEventsController;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaPositionType;

import java.util.List;

import expotek.com.prioritease.Bucket;
import expotek.com.prioritease.R;


@LayoutSpec
public class MainLayoutSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(final ComponentContext c,
                                          @Prop List<Bucket> bucketList,
                                          @Prop String title,
                                          @Prop BucketButtonSpec.OnButtonClickListener listener,
                                          @Prop RecyclerCollectionEventsController recyclerCollectionEventsController,
                                          RecyclerCollectionComponentSpec.RecyclerConfiguration recyclerConfiguration
//                                          ,@Prop FloatingButtonSpec.OnButtonClickListenerFloatingButton floatingButtonListener
    ) {

        Component titleString = Text.create(c, 0, R.style.TextAppearance_AppCompat_Title)
                .text(title)
                .textSizeDip(18)
                .typeface(Typeface.defaultFromStyle(Typeface.BOLD))
                .textAlignment(Layout.Alignment.ALIGN_CENTER)
                .build();


        Component list =
                RecyclerCollectionComponent.create(c)
                        .recyclerConfiguration(recyclerConfiguration)
                        .disablePTR(true)
                        .backgroundColor(Color.RED)
                        .alpha((float) .5)
                        .flexGrow(1)
                        .eventsController(recyclerCollectionEventsController)
                        .section(BucketList.create(new SectionContext(c)).bucketList(bucketList).listener(listener).build())
                        .heightDip(360)
                        .build();

        Component floatingButton = FloatingButton.create(c)
                .positionType(YogaPositionType.ABSOLUTE)
                .alignSelf(YogaAlign.FLEX_END)
                .clickHandler(MainLayout.onClick(c))
                .positionDip(YogaEdge.BOTTOM, 0)
                .marginDip(YogaEdge.BOTTOM, 5)
                .marginDip(YogaEdge.RIGHT, 5)
                .heightDip(60)
                .widthDip(60)
                .build();

        return Column.create(c)
                .child(titleString)
                .child(list)
                .child(floatingButton)
                .backgroundColor(Color.GREEN)
                .alpha((float) .4)
                .build();

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


}
