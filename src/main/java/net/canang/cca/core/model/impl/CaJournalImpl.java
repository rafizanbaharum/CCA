package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Entity(name = "CaJournal")
@Table(name = "CA_JOURNAL")
public class CaJournalImpl implements CaJournal {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_JOURNAL")
    @SequenceGenerator(name = "SEQ_CA_JOURNAL", sequenceName = "SEQ_CA_JOURNAL", allocationSize = 1)
    private Long id;

    @Column(name = "REFERENCE_NO")
    private String referenceNo;

    @Column(name = "SOURCE_NO")
    private String sourceNo;

    @Column(name = "AUDIT_NO")
    private String auditNo;

    @Column(name = "POSTING_STATUS")
    private CaPostingStatus postingStatus;

    @Column(name = "JOURNAL_TYPE")
    private CaJournalType journalType;

    @Column(name = "POSTED_DATE")
    private Date postedDate;
//    private CaCurrency currency;

    @Transient // TODO: for now
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
