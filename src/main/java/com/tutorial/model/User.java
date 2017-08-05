package com.tutorial.model;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "Users")
//@Where(clause = "type=0")
@Filter(name="userType",condition = "type =:type")
@FilterDef(name="userType",parameters = @ParamDef(name = "type",type = "int"))
//for locking object before any change happens in persistence context
@OptimisticLocking(type = OptimisticLockType.ALL)
@DynamicUpdate
@SelectBeforeUpdate
@NamedQueries(@NamedQuery(name = "getUserByName",query = "from User where name= :name"))
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    @NaturalId
    private String name;
    @Column(name = "email")
    private String email;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="type")
    private UserType type;
    @Column(name="history")
    @Lob
    private String history;

    @Column(name="CREATED_DATE")
    private Date createdDate;

    @Column(name="MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private java.util.Date modifiedDate;

    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private Collection<Address> address=new ArrayList<Address>();

    @OneToMany(mappedBy = "user_id",cascade = CascadeType.ALL)
    private Set<Credentials> creds=new HashSet<Credentials>();

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "permissions", joinColumns = @JoinColumn(name = "user_permission_id"))
    @GenericGenerator(name = "generic-gen",strategy = "sequence")
    @CollectionId(columns = {@Column(name="permission_id")},generator = "generic-gen",type = @Type(type = "long"))
    List<Integer> permissions=new ArrayList<Integer>();

    public User(){}
    public User( String name, String email,Date createdDate,java.util.Date modifiedDate) {
        this.name = name;
        this.email = email;
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
    }

    public User( String name, String email,UserType type,Date createdDate,java.util.Date modifiedDate) {
        this.name = name;
        this.email = email;
        this.type=type;
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
    }
    public User(String name, String email,UserType type,String history,Date createdDate,java.util.Date modifiedDate) {
        this.name = name;
        this.email = email;
        this.type=type;
        this.history=history;
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
    }

    public User(String name, String email,UserType type,String history,Date createdDate,java.util.Date modifiedDate,Address address) {
        this.name = name;
        this.email = email;
        this.type=type;
        this.history=history;
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
        this.address.add(address);
    }

    public Collection<Address> getAddress() {
        return address;
    }

    public void setAddress(Collection<Address> address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }
    public void setType(UserType type) {
        this.type = type;
    }

    public String getHistory() {
        return history;
    }
    public void setHistory(String history) {
        this.history = history;
    }

    public Set<Credentials> getCreds() {
        return creds;
    }
    public void setCreds(Set<Credentials> creds) {
        this.creds = creds;
    }

    public List<Integer> getPermissions() {return permissions;}
    public void setPermissions(List<Integer> permissions) {this.permissions = permissions;}

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public java.util.Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(java.util.Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", history='" + history + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", address=" + address +
                ", creds=" + creds +
                ", permissions=" + permissions +
                '}';
    }
}


