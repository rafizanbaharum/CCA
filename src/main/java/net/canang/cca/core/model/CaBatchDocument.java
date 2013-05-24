package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaBatchDocument extends CaAuditable, CaFlowObject, CaPostable{

    CaBatchType getBatchType();

    void setBatchType(CaBatchType batchType);

    CaBatchStatus getBatchStatus();

    void setBatchStatus(CaBatchStatus batchStatus);

}
