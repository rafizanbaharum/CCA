package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaDocument extends CaAuditable, CaFlowObject, CaPostable{

    String getReferenceNo();

    void setReferenceNo(String referenceNo);

    String getSourceNo();

    void setSourceNo(String sourceNo);

    CaDocumentType getDocumentType();

}
