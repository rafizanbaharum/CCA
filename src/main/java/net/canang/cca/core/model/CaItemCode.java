package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
// TODO: change to inventory code
public interface CaItemCode extends CaMetaObject, CaCodeable {

    boolean isAllowBackOrder();

    void setAllowBackOrder(boolean allowBackOrder);

    CaTaxType getPurchaseTaxType();

    void setPurchaseTaxType(CaTaxType purchaseTaxType);

    CaTaxType getSalesTaxType();

    void setSalesTaxType(CaTaxType salesTaxType);

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
