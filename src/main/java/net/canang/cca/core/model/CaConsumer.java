package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaConsumer extends CaMetaObject, CaCodeable {

    String getName();

    void setName(String name);

    String getEmail1();

    void setEmail2(String primaryEmail);

    String getAddress1();

    void setAddress1(String address);

    String getAddress2();

    void setAddress2(String address);

    String getAddress3();

    void setAddress3(String address);

    CaConsumerType getConsumerType();

    CaChequebook getChequebook();

    CaAccount getCashAccount();

    CaAccount getReceivableAccount();

    CaAccount getSalesAccount();

    CaAccount getInventoryAccount();
}
