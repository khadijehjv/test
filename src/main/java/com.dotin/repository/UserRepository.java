package com.example.demo.repository;


import com.example.demo.domain.Authority;
import com.example.demo.domain.Token;
import com.example.demo.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findUserByUsername(String userName);







//    @Override
//    public UUID getToken(User user) {
//        UUID uuid=null;
//        try(Session session= ORMConfig.openSession()){
//            session.beginTransaction();
//
//            if (!session.get(User.class,user.getId()).equals(null)){
//                uuid=UUID.randomUUID();
//                Token token=new Token();
//                token.setValue(uuid);
//                token.setIssueDate(new Date());
//                token.setExpireDate();
//                token.setUserId(user.getId());
//                //set id seq
//
//                session.save(token);
//            }
//
//
//            session.getTransaction().commit();
//            ORMConfig.currentSession().close();
//
//        }
//
//        return uuid;
//    }

}
