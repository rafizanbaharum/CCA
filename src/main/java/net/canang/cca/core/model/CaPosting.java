package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * enter/post standard/correcting transactions
 * void/delete unposted transactions
 * reverse posted transactions
 * post corrected entries
 * use quick journal for recurring entries
 * eliminate errors with account security
 *
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaPosting extends CaMetaObject {

    // TODO:company
//    CaCompany getCompany();
//
//    void setCompany(CaCompany company);

    String getDescription();

    void setDescription(String description);

    CaAccount getAccount();

    void setAccount(CaAccount account);

    CaJournal getJournal();

    void setJournal(CaJournal journal);

    BigDecimal getAmount();

    void setAmount(BigDecimal amount);

}
