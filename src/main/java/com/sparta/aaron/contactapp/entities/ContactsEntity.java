package com.sparta.aaron.contactapp.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contacts", schema = "security")
public class ContactsEntity {
    private int contactId;
    private String firstName;
    private String lastName;
    private String contactGroups;
    private String contactMethod;
    private Integer userId;
    private Integer maxPeriod;
    private Date lastContact;
    private BigDecimal timeScale;


    @Id
    @Column(name = "contact_id")
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "contact_groups")
    public String getContactGroups() {
        return contactGroups;
    }

    public void setContactGroups(String contactGroups) {
        this.contactGroups = contactGroups;
    }

    @Basic
    @Column(name = "contact_method")
    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }

    @Basic
    @Column(name = "user_Id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "max_period")
    public Integer getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(Integer maxPeriod) {
        this.maxPeriod = maxPeriod;
    }

    @Basic
    @Column(name = "last_contact")
    public Date getLastContact() {
        return lastContact;
    }

    public void setLastContact(Date lastContact) {
        this.lastContact = lastContact;
    }

    @Basic
    @Column(name = "time_scale")
    public BigDecimal getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(BigDecimal timeScale) {
        this.timeScale = timeScale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsEntity that = (ContactsEntity) o;
        return contactId == that.contactId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(contactGroups, that.contactGroups) && Objects.equals(contactMethod, that.contactMethod) && Objects.equals(userId, that.userId) && Objects.equals(maxPeriod, that.maxPeriod) && Objects.equals(lastContact, that.lastContact) && Objects.equals(timeScale, that.timeScale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, firstName, lastName, contactGroups, contactMethod, userId, maxPeriod, lastContact, timeScale);
    }
}
