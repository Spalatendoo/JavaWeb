package com.lk.pojo;

import java.util.Date;

public class Provider {
    private Integer id;
    private String proCode; //供应商编码
    private String proName; //供应商名字
    private String proDesc; //供应商描述
    private String proContact; //供应商联系人
    private String proPhone; //供应商电话
    private String proAddress; //供应商地址
    private String proFax; //供应商传真
    private Integer createdBy; //创建者
    private Date creationDate; //创建时间
    private Date modifyDate; //更新时间
    private Integer modifyBy; // 更新者

    public Provider() {
    }

    public Provider(Integer id,String proCode, String proName, String proDesc, String proContact, String proPhone, String proAddress, String proFax, Integer createdBy, Date creationDate, Date modifyDate, Integer modifyBy) {
        this.id = id;
        this.proCode = proCode; //供应商编码
        this.proName = proName; //供应商名字
        this.proDesc = proDesc;  //供应商描述
        this.proContact = proContact;  //供应商联系人
        this.proPhone = proPhone;  //供应商电话
        this.proAddress = proAddress;  //供应商地址
        this.proFax = proFax;  //供应商传真
        this.createdBy = createdBy; //创建者
        this.creationDate = creationDate;  //创建时间
        this.modifyDate = modifyDate;  //更新时间
        this.modifyBy = modifyBy;  //更新者
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getProContact() {
        return proContact;
    }

    public void setProContact(String proContact) {
        this.proContact = proContact;
    }

    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    public String getProFax() {
        return proFax;
    }

    public void setProFax(String proFax) {
        this.proFax = proFax;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }


}
