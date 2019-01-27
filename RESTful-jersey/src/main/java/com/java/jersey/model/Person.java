package com.java.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private Integer id;
    private String name;
    private String lastname;
    private Integer age;

    public Person() {

    }

    public Person(final Integer id, final String name, final String lastname, final Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    /**
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * @param paramId
     *            the id to set
     */
    public final void setId(final Integer paramId) {
        id = paramId;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param paramName
     *            the name to set
     */
    public final void setName(final String paramName) {
        name = paramName;
    }

    /**
     * @return the lastname
     */
    public final String getLastname() {
        return lastname;
    }

    /**
     * @param paramLastname
     *            the lastname to set
     */
    public final void setLastname(final String paramLastname) {
        lastname = paramLastname;
    }

    /**
     * @return the age
     */
    public final Integer getAge() {
        return age;
    }

    /**
     * @param paramAge
     *            the age to set
     */
    public final void setAge(final Integer paramAge) {
        age = paramAge;
    }
}
