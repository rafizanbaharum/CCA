package net.canang.cca.core.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaBatchReceipt extends CaBatchDocument {

    BigDecimal getTotalAmount();

    void setTotalAmount(BigDecimal totalAmount);

    CaChequebook getChequebook();

    void setChequebook(CaChequebook chequebook);

    List<CaReceipt> getReceipts();

    void setReceipts(List<CaReceipt> receipts);
}
