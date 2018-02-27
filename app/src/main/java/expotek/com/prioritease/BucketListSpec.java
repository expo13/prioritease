package expotek.com.prioritease;

import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;
import com.facebook.litho.widget.Text;

import java.util.List;

@GroupSectionSpec
public class BucketListSpec {

    @OnCreateChildren
    static Children onCreateChildren(final SectionContext c, @Prop List<Bucket> bucketList, @Prop BucketButtonSpec.OnButtonClickListener listener) {
        Children.Builder builder = Children.create();

        for (Bucket b : bucketList) {
            builder.child(
                    SingleComponentSection.create(c)
                            .key(b.getName())
                            .component(BucketButton.create(c).buttonName(b.getName()).listener(listener).build()));
        }

        return builder.build();
    }
}