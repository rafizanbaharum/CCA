package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaPurchaseInvoice;
import net.canang.cca.core.model.CaPurchaseInvoiceItem;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaPurchaseInvoiceDao {

    CaPurchaseInvoice findById(Long id);

    CaPurchaseInvoice findByReferenceNo(String referenceNo);

    CaPurchaseInvoice findBySourceNo(String sourceNo);

    CaPurchaseInvoice findByAuditNo(String auditNo);

    List<CaPurchaseInvoice> find();

    void save(CaPurchaseInvoice invoice, CaUser user);

    void update(CaPurchaseInvoice invoice, CaUser user);

    void remove(CaPurchaseInvoice invoice, CaUser user);

    void addItem(CaPurchaseInvoice purchaseInvoice, CaPurchaseInvoiceItem invoiceItem, CaUser user);
}
