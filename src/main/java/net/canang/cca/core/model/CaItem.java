package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
// TODO: change to inventory
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

    CaItemPriceLevel getDefaultPriceLevel();

    void setDefaultPriceLevel(CaItemPriceLevel priceLevel);

    List<CaItemPriceLevel> getPriceLevels();

    void setPriceLevels(List<CaItemPriceLevel> priceLevels);

    // transient?
    BigDecimal getQuantityOnHand();

    BigDecimal getQuantityAvailable();


}
