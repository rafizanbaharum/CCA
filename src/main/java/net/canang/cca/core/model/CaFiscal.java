package net.canang.cca.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaFiscal extends CaMetaObject {

    Integer getYear();

    void setYear(Integer year);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    CaFiscalStatus getFiscalStatus();

    void setFiscalStatus(CaFiscalStatus fiscalStatus);

}
