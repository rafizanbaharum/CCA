package net.canang.cca.core.model.impl;

import net.canang.cca.core.model.CaAccount;
import net.canang.cca.core.model.CaChequebook;
import net.canang.cca.core.model.CaConsumer;
import net.canang.cca.core.model.CaConsumerType;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 5/24/13
 */
@Entity(name = "CaConsumer")
@Table(name = "CA_CONSUMER")
@Inheritance(strategy = InheritanceType.JOINED)
public class CaConsumerImpl implements CaConsumer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CA_CONSUMER")
    @SequenceGenerator(name = "SEQ_CA_CONSUMER", sequenceName = "SEQ_CA_CONSUMER", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "PHONE1")
    private String phone1;

    @Column(name = "PHONE2")
    private String phone2;

    @Column(name = "EMAIL1")
    private String email1;

    @Column(name = "EMAIL2")
    private String email2;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "ADDRESS3")
    private String address3;

    @Column(name = "CONSUMER_TYPE")
    private CaConsumerType consumerType;

//    @ManyToOne(targetEntity = CaChequebookImpl.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "CHEQUEBOOK_ID")
//    private CaChequebook chequebook;

//    @ManyToOne(targetEntity = CaAccountImpl.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "INVENTORY_ACCOUNT_ID")
//    private CaAccount inventoryAccount;

//    @ManyToOne(targetEntity = CaAccountImpl.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "RECEIVABLE_ACCOUNT_ID")
//    private CaAccount receivableAccount;

//    @ManyToOne(targetEntity = CaAccountImpl.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "SALES_ACCOUNT_ID")
//    private CaAccount salesAccount;

//    @ManyToOne(targetEntity = CaAccountImpl.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "CASH_ACCOUNT_ID")
//    private CaAccount cashAccount;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public CaConsumerType getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(CaConsumerType consumerType) {
        this.consumerType = consumerType;
    }

//    public CaChequebook getChequebook() {
//        return chequebook;
//    }
//
//    public void setChequebook(CaChequebook chequebook) {
//        this.chequebook = chequebook;
//    }
//
//    public CaAccount getInventoryAccount() {
//        return inventoryAccount;
//    }
//
//    public void setInventoryAccount(CaAccount inventoryAccount) {
//        this.inventoryAccount = inventoryAccount;
//    }
//
//    public CaAccount getReceivableAccount() {
//        return receivableAccount;
//    }
//
//    public void setReceivableAccount(CaAccount receivableAccount) {
//        this.receivableAccount = receivableAccount;
//    }
//
//    public CaAccount getSalesAccount() {
//        return salesAccount;
//    }
//
//    public void setSalesAccount(CaAccount salesAccount) {
//        this.salesAccount = salesAccount;
//    }
//
//    public CaAccount getCashAccount() {
//        return cashAccount;
//    }
//
//    public void setCashAccount(CaAccount cashAccount) {
//        this.cashAccount = cashAccount;
//    }
}
