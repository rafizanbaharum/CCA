package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaDocument;
import net.canang.cca.core.model.CaDocumentType;
import net.canang.cca.core.model.CaPostingStatus;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public abstract class CaDocumentImpl implements CaDocument {

    private Long id;
    private String referenceNo;
    private String sourceNo;
    private String auditNo;
    private Date postedDate;
    private CaDocumentType documentType;
    private CaPostingStatus postingStatus;

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

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public CaDocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(CaDocumentType documentType) {
        this.documentType = documentType;
    }

    public CaPostingStatus getPostingStatus() {
        return postingStatus;
    }

    public void setPostingStatus(CaPostingStatus postingStatus) {
        this.postingStatus = postingStatus;
    }
}
