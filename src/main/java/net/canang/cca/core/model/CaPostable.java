package net.canang.cca.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaPostable {

    Date getPostedDate();

    void setPostedDate(Date postedDate);

    CaPostingStatus getPostingStatus();

    void setPostingStatus(CaPostingStatus postingStatus);

}
