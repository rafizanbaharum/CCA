package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaSiteCode;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 5/25/13
 */
@Entity(name = "CaSiteCode")
@Table(name = "CA_SITE_CODE")
public class CaSiteCodeImpl implements CaSiteCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_SITE_CODE")
    @SequenceGenerator(name = "SEQ_CA_SITE_CODE", sequenceName = "SEQ_CA_SITE_CODE", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ALIAS")
    private String alias;

//    @Transient
//    private String address1;
//
//    @Transient
//    private String address2;
//
//    @Transient
//    private String address3;
//
//    @Transient
//    private String city;
//
//    @Transient
//    private String state;
//
//    @Transient
//    private String zipcode;
//
//    @Transient
//    private String country;
//
//    @Transient
//    private String phone1;
//
//    @Transient
//    private String phone2;
//
//    @Transient
//    private String fax;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

//    public String getAddress1() {
//        return address1;
//    }
//
//    public void setAddress1(String address1) {
//        this.address1 = address1;
//    }
//
//    public String getAddress2() {
//        return address2;
//    }
//
//    public void setAddress2(String address2) {
//        this.address2 = address2;
//    }
//
//    public String getAddress3() {
//        return address3;
//    }
//
//    public void setAddress3(String address3) {
//        this.address3 = address3;
//    }
//
//    public String getPhone1() {
//        return phone1;
//    }
//
//    public void setPhone1(String phone1) {
//        this.phone1 = phone1;
//    }
//
//    public String getPhone2() {
//        return phone2;
//    }
//
//    public void setPhone2(String phone2) {
//        this.phone2 = phone2;
//    }
//
//    public String getFax() {
//        return fax;
//    }
//
//    public void setFax(String fax) {
//        this.fax = fax;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
}
