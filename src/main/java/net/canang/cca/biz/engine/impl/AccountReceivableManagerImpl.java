package net.canang.cca.biz.engine.impl;

import net.canang.cca.biz.engine.AccountReceivableManager;
import net.canang.cca.core.model.CaBatchDocument;
import net.canang.cca.core.model.CaDocument;
import net.canang.cca.core.model.CaDocumentType;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class AccountReceivableManagerImpl implements AccountReceivableManager {


    @Override
    public CaDocument draft(CaDocumentType type, CaBatchDocument document) {
        return null;  // TODO:

    }

    @Override
    public void update(CaDocument document) {
        // TODO:

    }

    @Override
    public void post(CaDocument document) {
        // TODO:

    }

    @Override
    public void post(CaBatchDocument batchDocument) {
        // TODO:

    }
}
