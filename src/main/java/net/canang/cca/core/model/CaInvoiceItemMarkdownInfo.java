package net.canang.cca.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaInvoiceItemMarkdownInfo {

    CaInvoiceItemMarkdownType getMarkdownType();

    void setMarkdownType(CaInvoiceItemMarkdownType markdownType);

    BigDecimal getMarkdown();

    void setMarkdown(BigDecimal markdown);

    BigDecimal getAdjustedUnitPrice();

    void setAdjustedUnitPrice(BigDecimal adjustedUnitPrice);

    BigDecimal getExtendedPrice();

    void setExtendedPrice(BigDecimal extendedPrice);
}
