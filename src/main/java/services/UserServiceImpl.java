package services;

import com.google.inject.persist.Transactional;
import dtos.UserDTO;
import models.User;
import ninja.jpa.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/17
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    private Provider<EntityManager> entityManagerProvider;

    @Override
    @UnitOfWork
    public List<UserDTO> list() {
        EntityManager entityManager = entityManagerProvider.get();

        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u order by u.id", User.class);
        List<User> typedQueryResultList = typedQuery.getResultList();

        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : typedQueryResultList) {
            UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getSex());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    @Transactional
    public void register(UserDTO userDTO) {

        EntityManager entityManager = entityManagerProvider.get();

        User user = new User(userDTO);
        entityManager.persist(user);

        LOGGER.info("ユーザー登録完了 id: {}", user.getId());
    }
}
