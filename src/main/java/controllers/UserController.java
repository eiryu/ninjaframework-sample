package controllers;

import com.google.inject.Singleton;
import dtos.UserDTO;
import forms.Sex;
import forms.UserForm;
import ninja.Result;
import ninja.Results;
import ninja.exceptions.BadRequestException;
import ninja.session.Session;
import ninja.validation.FieldViolation;
import ninja.validation.JSR303Validation;
import ninja.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.UserService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/14
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    public Result list() {
        List<UserDTO> users = userService.list();
        return Results.html().render("users", users);
    }

    public Result inputRegister(Session session) {
        session.clear();
        return Results.html();
    }

    public Result confirmRegister(@JSR303Validation UserForm userForm/*, @SexParameter Sex sex*/, Session session/*, @SkillParameter String[] skills*/, Validation validation) {
        LOGGER.debug("name: {}", userForm.getName());
        LOGGER.debug("sex: {}", userForm.getSex());
//        LOGGER.debug("" + (userForm.getSkills() == null));
//        for (Integer skill : userForm.getSkills()) {
//            LOGGER.debug("userform skill: "  + skill);
//        }
//        for (String skill : skills) {
//            LOGGER.debug("param skill: " + skill);
//        }

//        LOGGER.debug("" + sex);

        if (validation.hasBeanViolations()) {
            for (FieldViolation fieldViolation : validation.getBeanViolations()) {
                // MALE、FEMALE以外の性別が指定された
                if ("sex".equals(fieldViolation.field) && "{sex.invalid}".equals(fieldViolation.constraintViolation.getMessageKey())) {
                    throw new BadRequestException();
                }

                LOGGER.debug("fieldViolation.field: {}", fieldViolation.field);
                LOGGER.debug("fieldViolation.constraintViolation.getMessageKey: {}", fieldViolation.constraintViolation.getMessageKey());
            }

            Result result = Results.html();
            result.render("violations", validation.getBeanViolations());
            result.render("user", userForm);
            result.template("views/UserController/inputRegister.ftl.html");
            return result;
        }

        // セッションに保持
        session.put("name", userForm.getName());
        session.put("sex", userForm.getSex());

        Result result = Results.html();
        result.render("sex", Enum.valueOf(Sex.class, userForm.getSex()));
        result.render("user", userForm);

        return result;
    }

    public Result completeRegister(Session session) {
        String name = session.get("name");
        String sex = session.get("sex");

        LOGGER.debug("name: {}", name);
        LOGGER.debug("sex: {}", sex);

        userService.register(new UserDTO(name, Enum.valueOf(Sex.class, sex)));

        session.clear();

        // ユーザー一覧へ
        return Results.redirect("/user/");
    }

}
