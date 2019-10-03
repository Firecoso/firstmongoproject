package org.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Document(collection = "EMPLOYEE")
public class Employee {

    @Id
    @Field(value = "ID")
    private String id;

    @Indexed(unique=true)
    @Field(value = "CODE")
    private String code;

    @Field(value = "FULL_NAME")
    private String fullName;

    @Field(value = "START_DATE")
    private Date startDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
