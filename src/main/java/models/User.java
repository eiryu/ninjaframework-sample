package models;

import dtos.UserDTO;
import forms.Sex;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/17
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Version
    private Integer version;

    public User() {
    }

    public User(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public User(UserDTO userDTO) {
        name = userDTO.getName();
        sex = userDTO.getSex();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
