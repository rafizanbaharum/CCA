package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaJournalImpl implements CaJournal {

    private Long id;
    private String referenceNo;
    private String sourceNo;
    private String auditNo;
    private CaPostingStatus postingStatus;
    private CaJournalType journalType;
    private Date postedDate;
//    private CaCurrency currency;
    private List<CaPosting> postings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public String getAuditNo() {
        return auditNo;
    }

    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo;
    }

    public CaPostingStatus getPostingStatus() {
        return postingStatus;
    }

    public void setPostingStatus(CaPostingStatus postingStatus) {
        this.postingStatus = postingStatus;
    }

    public CaJournalType getJournalType() {
        return journalType;
    }

    public void setJournalType(CaJournalType journalType) {
        this.journalType = journalType;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public List<CaPosting> getPostings() {
        return postings;
    }

    public void setPostings(List<CaPosting> postings) {
        this.postings = postings;
    }

//    public CaCurrency getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(CaCurrency currency) {
//        this.currency = currency;
//    }
}
