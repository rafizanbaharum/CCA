package net.canang.cca.core.model;

import java.util.List;

/**
 * 3 segments
 * Location = Site/Dept
 * Account =
 * XX      =
 * <p/>
 * 000 NONE
 * 100 ADMINISTRATION
 * 200 ACCOUNTING
 * 300 SALES
 * 400 SERVICE INSTALLATION
 * 500 CONSULTING TRAINING
 * 600 PURCHASING RECEIVING
 * <p/>
 *
 * Account can only be closed if
 * - No balance
 * - No activity for an open period
 * - No account history amounts
 * - Not part of an allocation account
 * - Not part of an unposted transaction
 * - No multicurrency data
 * - No transaction history records
 *
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaAccount extends CaMetaObject, CaCodeable {

    CaAccountType getAccountType();

    CaBalanceType getBalanceType();

    CaPostingType getPostingType();

    CaDepartmentCode getDepartmentCode();

    CaAccountCode getAccountCode();

    CaProjectCode getProjectCode();

    List<CaAccountPostingLevel> getPostingLevels();

    List<CaAccountPostingLookup> getPostingLookups();
}
