package net.canang.cca.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaJournal extends CaMetaObject, CaPostable, CaAuditable {

    String getReferenceNo();

    String getSourceNo();

//    CaCurrency getCurrency();
//
//    void setCurrency(CaCurrency currency);

    CaJournalType getJournalType();

    void setJournalType(CaJournalType journalType);

    List<CaPosting> getPostings();

    void setPostings(List<CaPosting> postings);
}

