package net.canang.cca.core.model;

/**
 * 1 – Currency Amount
 * 2 – % of List Price
 * 3 – % Markup – Current Cost
 * 4 – % Markup – Standard Cost
 * 5 – % Margin – Current Cost
 * 6 – % Margin – Standard Cost
 *
 * @author rafizan.baharum
 * @since 5/25/13
 */
public enum CaItemPriceMethod {
    CURRENCY_AMOUNT,
    PERCENTAGE_MARKUP_CURRENT_COST,
    PERCENTAGE_MARKUP_STANDARD_COST,
    PERCENTAGE_MARGIN_CURRENT_COST,
    PERCENTAGE_MARGIN_STANDARD_COST;
}
