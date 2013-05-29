package net.canang.cca.core.model;

/**
 * Dynamics Term: Item Class
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaItemCode extends CaMetaObject, CaCodeable {

    boolean isAllowBackOrder();

    void setAllowBackOrder(boolean allowBackOrder);

    CaTaxType geArTaxType();

    void setArTaxType(CaTaxType artTaxType);

    CaTaxType getApTaxType();

    void setApTaxType(CaTaxType apTaxType);

    CaUnitCode getUnitCode();

    void setUnitCode(CaUnitCode unitCode);

    CaAccount getInventoryAccount();

    CaAccount getInventoryOffsetAccount();

    CaAccount getCogsAccount();

    CaAccount getSalesAccount();

    CaAccount getMarkdownAccount();

    CaAccount getSalesReturnAccount();

    CaAccount getInventoryReturnAccount();

}
