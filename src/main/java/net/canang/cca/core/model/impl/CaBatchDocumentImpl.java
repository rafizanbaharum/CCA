package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaBatchDocument;
import net.canang.cca.core.model.CaBatchStatus;
import net.canang.cca.core.model.CaBatchType;
import net.canang.cca.core.model.CaPostingStatus;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public abstract class CaBatchDocumentImpl implements CaBatchDocument {

    private Long id;
    private String referenceNo;
    private String sourceNo;
    private String auditNo;
    private CaBatchStatus batchStatus;
    private CaBatchType batchType;
    private CaPostingStatus postingStatus;
    private Date postedDate;


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

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public CaBatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(CaBatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public CaBatchType getBatchType() {
        return batchType;
    }

    public void setBatchType(CaBatchType batchType) {
        this.batchType = batchType;
    }
}
