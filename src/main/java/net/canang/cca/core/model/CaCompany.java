package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaCompany extends CaMetaObject, CaCodeable {


    String getPrimaryPhone();

    void setPrimaryPhone(String primaryPhone);

    String getSecondaryPhone();

    void setSecondaryPhone(String secondaryPhone);

    String getPrimaryEmail();

    void setPrimaryEmail(String primaryEmail);

    String getSecondaryEmail();

    void setSecondaryEmail(String secondaryEmail);

    String getPhone();

    void setPhone(String phone);

    String getFax();

    void setFax(String fax);

    String getAddress1();

    void setAddress1(String address);

    String getAddress2();

    void setAddress2(String address);

    String getCity();

    void setCity(String city);

    String getState();

    void setState(String state);

    String getZipcode();

    void setZipcode(String zipcode);

    String getCountry();

    void setCountry(String country);

}
