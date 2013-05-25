package net.canang.cca.core.model;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
public interface CaBank extends CaMetaObject, CaCodeable {

    String getAddress1();

    void setAddress1(String address1);

    String getAddress2();

    void setAddress2(String address2);

    String getCity();

    void setCity(String city);

    String getCountry();

    void setCountry(String country);

    String getZipcode();

    void setZipcode(String zipcode);

    String getPhone();

    void setPhone(String phone);

    String getFax();

    void setFax(String fax);

    String getEmail();

    void setEmail(String email);

}
