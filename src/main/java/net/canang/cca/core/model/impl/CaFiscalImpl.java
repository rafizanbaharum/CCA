package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaFiscal;
import net.canang.cca.core.model.CaFiscalStatus;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public class CaFiscalImpl implements CaFiscal {

    private Long id;
    private Integer year;
    private Date startDate;
    private Date endDate;
    private CaFiscalStatus fiscalStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CaFiscalStatus getFiscalStatus() {
        return fiscalStatus;
    }

    public void setFiscalStatus(CaFiscalStatus fiscalStatus) {
        this.fiscalStatus = fiscalStatus;
    }
}
