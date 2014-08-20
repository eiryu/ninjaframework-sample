package services;

import dtos.UserDTO;
import ninja.jpa.UnitOfWork;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/17
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    
    List<UserDTO> list();
    void register(UserDTO userDTO);
}
