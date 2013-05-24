package net.canang.cca.biz.engine;

import net.canang.cca.core.model.CaPostable;
import org.springframework.context.ApplicationEvent;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class PostingEvent extends ApplicationEvent {

    private final CaPostable postable;

    public PostingEvent(Object source, CaPostable postable) {
        super(source);
        this.postable = postable;
    }

    public CaPostable getPostable() {
        return postable;
    }

    @Override
    public String toString() {
        return "PostingEvent{" +
                "postable=" + postable +
                '}';
    }
}
