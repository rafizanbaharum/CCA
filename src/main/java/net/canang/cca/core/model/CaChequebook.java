package net.canang.cca.core.model;

import java.util.Date;

/**
 * allow multicurrency
 *
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaChequebook extends CaMetaObject, CaCodeable {

    Integer getNextChequeNo();

    void setNextChequeNo(Integer nextChequeNo);

    Date getReconciliationDate();

    void setReconciliationDate(Date reconciliation);

    CaAccount getAccount();

    void setAccount(CaAccount account);

    CaBank getBank();

    void setBank(CaBank bank);

}
