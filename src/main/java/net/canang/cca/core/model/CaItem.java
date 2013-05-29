package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * NOTE: price level one currency only
 *
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaItem extends CaMetaObject, CaCodeable {

    String getShortDescription();

    void setShortDescription(String shortDescription);

    String getGenericDescription();

    void setGenericDescription(String genericDescription);

    BigDecimal getStandardCost();

    void setStandardCost(BigDecimal standardCost);

    BigDecimal getCurrentCost();

    void setCurrentCost(BigDecimal currentCost);

    CaItemPriceMethod getPriceMethod();

    void setPriceMethod(CaItemPriceMethod priceMethod);

    CaItemPrice getDefaultPrice();

    void setDefaultPrice(CaItemPrice price);

    CaAccount getUnitAccount();

    void setUnitAccount(CaAccount account);

    List<CaItemPrice> getPrices();

    void setPrices(List<CaItemPrice> prices);

    // transient?
    BigDecimal getQuantityOnHand();

    BigDecimal getQuantityAvailable();


}
