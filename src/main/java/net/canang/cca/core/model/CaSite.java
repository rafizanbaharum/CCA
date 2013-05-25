package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
public interface CaSite extends CaMetaObject, CaCodeable{


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
