package net.canang.cca.biz.engine;

import net.canang.cca.core.model.CaBatchJournal;
import net.canang.cca.core.model.CaJournal;
import net.canang.cca.core.model.CaPostable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class PostingListener implements ApplicationListener<PostingEvent> {

    @Autowired
    private LedgerManager ledgerManager;

    @Override
    public void onApplicationEvent(PostingEvent event) {
        CaPostable postable = event.getPostable();

        if (postable instanceof CaJournal || postable instanceof CaBatchJournal) {
            ledgerManager.post(postable);
        } else if (postable instanceof CaJournal || postable instanceof CaBatchJournal){
            ledgerManager.post(postable);
        }
    }
}
