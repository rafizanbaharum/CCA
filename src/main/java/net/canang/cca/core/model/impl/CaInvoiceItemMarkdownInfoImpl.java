package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaInvoiceItemMarkdownInfo;
import net.canang.cca.core.model.CaInvoiceItemMarkdownType;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaInvoiceItemMarkdownInfoImpl implements CaInvoiceItemMarkdownInfo {

    private CaInvoiceItemMarkdownType markdownType;
    private BigDecimal markdown;
    private BigDecimal adjustedUnitPrice;
    private BigDecimal extendedPrice;

    public CaInvoiceItemMarkdownType getMarkdownType() {
        return markdownType;
    }

    public void setMarkdownType(CaInvoiceItemMarkdownType markdownType) {
        this.markdownType = markdownType;
    }

    public BigDecimal getMarkdown() {
        return markdown;
    }

    public void setMarkdown(BigDecimal markdown) {
        this.markdown = markdown;
    }

    public BigDecimal getAdjustedUnitPrice() {
        return adjustedUnitPrice;
    }

    public void setAdjustedUnitPrice(BigDecimal adjustedUnitPrice) {
        this.adjustedUnitPrice = adjustedUnitPrice;
    }

    public BigDecimal getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(BigDecimal extendedPrice) {
        this.extendedPrice = extendedPrice;
    }
}
