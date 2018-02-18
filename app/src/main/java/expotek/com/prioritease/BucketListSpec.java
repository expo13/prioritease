package expotek.com.prioritease;

import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;

@GroupSectionSpec
public class BucketListSpec {

    @OnCreateChildren
    static Children onCreateChildren(final SectionContext c) {
        Children.Builder builder = Children.create();

        for (int i = 0; i < 32; i++) {
            builder.child(
                    SingleComponentSection.create(c)
                            .key(String.valueOf(i))
                            .component(BucketButton.create(c).build()));
        }
        return builder.build();
    }
}