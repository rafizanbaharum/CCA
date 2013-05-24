package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaAccountPostingLookup extends CaMetaObject {

    CaAccount getAccount();

    CaSeries getSeries();

}
