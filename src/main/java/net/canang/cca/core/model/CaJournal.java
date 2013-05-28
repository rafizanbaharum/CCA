package net.canang.cca.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaJournal extends CaMetaObject, CaPostable, CaAuditable {

    String getReferenceNo();

    void setReferenceNo(String referenceNo);

    String getSourceNo();

    void setSourceNo(String sourceNo);

//    CaCurrency getCurrency();
//
//    void setCurrency(CaCurrency currency);

    CaJournalType getJournalType();

    void setJournalType(CaJournalType journalType);

    CaDocument getDocument();

    void setDocument(CaDocument document);

    List<CaPosting> getPostings();

    void setPostings(List<CaPosting> postings);
}

