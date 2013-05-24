package net.canang.cca.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaBatchJournal extends CaBatchDocument{

    List<CaJournal> getJournals();

    void setJournals(List<CaJournal> journals);
}
