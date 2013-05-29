package net.canang.cca.biz.engine.impl;

import net.canang.cca.biz.engine.ReferenceNoService;
import net.canang.cca.core.model.CaDocumentType;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
@Component("referenceNoService")
public class ReferenceNoServiceImpl implements ReferenceNoService {

    // TODO:
    @Override
    public String generate(CaDocumentType type) {
        String generated = null;
        switch (type) {
            case INVOICE:
                generated = "XXX";
                break;
            case SALES_ORDER:
                generated = "XXX";
                break;
            case PURCHASE_ORDER:
                generated = "XXX";
                break;
            case SALES_INVOICE:
                break;
            case PURCHASE_INVOICE:
                break;
        }
        return generated;
    }
}
