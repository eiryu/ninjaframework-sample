package dtos;

import forms.Sex;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/17
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
public class UserDTO {
    private Integer id;
    private String name;
    private Sex sex;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, Sex sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public UserDTO(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
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
}
