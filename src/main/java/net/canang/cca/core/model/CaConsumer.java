package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaConsumer extends CaMetaObject, CaCodeable {

    String getName();

    void setName(String name);

    String getStatementName();

    void setStatementName(String statementName);

    String getPrimaryPhone();

    void setPrimaryPhone(String primaryPhone);

    String getSecondaryPhone();

    void setSecondaryPhone(String secondaryPhone);

    String getPrimaryEmail();

    void setPrimaryEmail(String primaryEmail);

    String getSecondaryEmail();

    void setSecondaryEmail(String secondaryEmail);

    String getAddress();

    void setAddress(String address);

    CaCheckbook getCheckbook();

    CaAccount getCashAccount();
    CaAccount getAccountReceivableAccount();
    CaAccount getSalesAccount();
    CaAccount getInventoryAccount();



}
