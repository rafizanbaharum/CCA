package net.canang.cca.biz.engine;

import net.canang.cca.core.model.*;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface AccountPayableManager {

    CaDocument draft(CaDocumentType type, CaBatchDocument document);

    void update(CaDocument document);

    void post(CaDocument document);

    void post(CaBatchDocument batchDocument);

}
