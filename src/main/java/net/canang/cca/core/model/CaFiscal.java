package net.canang.cca.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaFiscal extends CaMetaObject {

    Integer getYear();

    Date getStartDate();

    Date getEndDate();

    CaFiscalStatus getStatus();

}
