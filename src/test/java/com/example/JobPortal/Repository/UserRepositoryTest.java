package com.example.JobPortal.Repository;

import com.example.JobPortal.Entity.UserEntity;
import com.example.JobPortal.Utils.AppUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity;

    @BeforeEach
    public void setup(){
        userEntity=new UserEntity();
        userEntity.setUserName("Prasanna");
        userEntity.setEmail("prasannag@gmail.com");
        userEntity.setCompanyName("CompanyName");
        userEntity.setPassword("123Prasanna@");
        userEntity.setRole(AppUtils.UserRoles.EMPLOYER);
    }

    @Test
    public void givenUserObject_whenSaved_returnsSavedUser()
    {
UserEntity user=userRepository.save(userEntity);
assertThat(user).isNotNull();
assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    public void givenUserData_whenUpdated_returnUpdatedUser(){
        UserEntity user=new UserEntity();
        user.setCompanyName("AWS");
        UserEntity userEntity=userRepository.save(user);
        assertThat(userEntity).isNotNull();
        assertThat(userEntity.getId()).isGreaterThan(0);
    }


}
