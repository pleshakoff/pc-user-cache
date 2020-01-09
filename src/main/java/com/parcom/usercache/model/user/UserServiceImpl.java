package com.parcom.usercache.model.user;

import com.parcom.network.Network;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private  final Network network;
    private  final UserRepository userRepository;


    @Override
    public User getById(Long id){
        log.info("Get user data from cache for id {}",id);
        return userRepository.findById(id).orElseGet(() -> getUserFromClassroom(id));
    }

    @Override
    public void delete(Long id) {
        log.info("Reset user data from cache for id {}",id);
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        log.info("Reset cache for all users");
        userRepository.deleteAll();
    }

    private User getUserFromClassroom(Long id) {
        log.info("User data not found in cache for id {}",id);
        User user = network.callGet("classroom", User.class, "users", id.toString()).getBody();
        log.info("Save  user data into cache for id {}",id);
        userRepository.save(user);
        return user;
    }


}