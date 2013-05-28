package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaDocument;
import net.canang.cca.core.model.CaDocumentType;
import net.canang.cca.core.model.CaPostingStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Entity(name = "CaDocument")
@Table(name = "CA_DOCUMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CaDocumentImpl implements CaDocument {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_DOCUMENT")
    @SequenceGenerator(name = "SEQ_CA_DOCUMENT", sequenceName = "SEQ_CA_DOCUMENT", allocationSize = 1)
    private Long id;

    @Column(name = "REFERENCE_NO", nullable = false)
    private String referenceNo;

    @Column(name = "SOURCE_NO")
    private String sourceNo;

    @Column(name = "AUDIT_NO")
    private String auditNo;

    @Column(name = "POSTED_DATE")
    private Date postedDate;

    @Column(name = "DOCUMENT_TYPE")
    private CaDocumentType documentType;

    @Column(name = "POSTING_STATUS")
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
