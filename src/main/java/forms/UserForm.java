package forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/15
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
public class UserForm {

    @NotBlank(message = "{name.blank}")
    private String name;

//    private Sex sex;
    @NotNull(message = "{sex.null}")
    @Pattern(regexp = "MALE|FEMALE", message = "{sex.invalid}")
    private String sex;

    //    private List<Integer> skills;
    private Integer[] skills;

    public UserForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Sex getSex() {
//        return sex;
//    }
//
//    public void setSex(Sex sex) {
//        this.sex = sex;
//    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


//    public List<Integer> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Integer> skills) {
//        this.skills = skills;
//    }

    public Integer[] getSkills() {
        return skills;
    }

    public void setSkills(Integer[] skills) {
        this.skills = skills;
    }
}
