package net.canang.cca.core.dao;

import net.canang.cca.core.model.CaInvoice;
import net.canang.cca.core.model.CaUser;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Component("invoiceDao")
public interface CaInvoiceDao {

    CaInvoice findById(Long id);

    CaInvoice findByReferenceNo(String referenceNo);

    CaInvoice findBySourceNo(String sourceNo);

    CaInvoice findByAuditNo(String auditNo);

    void save(CaInvoice invoice, CaUser user);

    void update(CaInvoice invoice, CaUser user);
}
