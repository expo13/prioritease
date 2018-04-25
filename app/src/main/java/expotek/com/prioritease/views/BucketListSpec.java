package expotek.com.prioritease.views;

import android.content.Context;

import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;

import java.util.List;

import expotek.com.prioritease.Bucket;
import expotek.com.prioritease.MainActivity;

@GroupSectionSpec
public class BucketListSpec implements MainActivity.OnContactsRefresh {

    @OnCreateChildren
    static Children onCreateChildren(final SectionContext c, @Prop List<Bucket> bucketList, @Prop BucketButtonSpec.OnButtonClickListener listener) {
        Children.Builder builder = Children.create();

        int x=0;
        for (Bucket b : bucketList) {
            builder.child(
                    SingleComponentSection.create(c)
                            .key(b.getName()+x)
                            .component(BucketButton.create(c).buttonName(b.getName()).listener(listener).build()));
            x++;
        }

        return builder.build();
    }

//    @Override
//    public void onContactsRefresh(SectionContext c, List<Bucket> bucketList, BucketButtonSpec.OnButtonClickListener listener) {
//        onCreateChildren(c, bucketList, listener);
//    }
}