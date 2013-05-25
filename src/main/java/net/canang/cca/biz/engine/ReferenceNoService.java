package net.canang.cca.biz.engine;

import net.canang.cca.core.model.CaDocumentType;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface ReferenceNoService {

    String generate(CaDocumentType type);
}
