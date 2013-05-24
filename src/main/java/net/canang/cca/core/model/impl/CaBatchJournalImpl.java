package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.*;

import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public class CaBatchJournalImpl extends CaBatchDocumentImpl implements CaBatchJournal {

    private List<CaJournal> journals;

    public List<CaJournal> getJournals() {
        return journals;
    }

    public void setJournals(List<CaJournal> journals) {
        this.journals = journals;
    }
}
