package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaSalesInvoice;
import net.canang.cca.core.model.CaSalesInvoiceItem;
import net.canang.cca.core.model.CaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaSalesInvoiceDao {

    CaSalesInvoice findById(Long id);

    CaSalesInvoice findByReferenceNo(String referenceNo);

    CaSalesInvoice findBySourceNo(String sourceNo);

    CaSalesInvoice findByAuditNo(String auditNo);

    List<CaSalesInvoice> find();

    void save(CaSalesInvoice invoice, CaUser user);

    void update(CaSalesInvoice invoice, CaUser user);

    void remove(CaSalesInvoice invoice, CaUser user);

    void addItem(CaSalesInvoice salesInvoice, CaSalesInvoiceItem InvoiceItem, CaUser user);

    void addItems(CaSalesInvoice salesInvoice, List<CaSalesInvoiceItem> invoiceItems, CaUser user);
}
