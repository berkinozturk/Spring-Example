package com.berkin.example.repository;


import com.berkin.example.entity.UserEntity;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RegisterBeanMapper(UserEntity.class)
public interface UserRepository {
    @SqlQuery("select * from users;")
    List<UserEntity> findAll();
    @SqlQuery("select * from users where id = :id;")
    UserEntity findById(@Bind("id") long id);

    @Transaction
    @SqlUpdate("delete from users where id = :id;")
    int deleteById(@Bind("id") long id);

    @Transaction
    @SqlUpdate("update users set lastname = :lastname, firstname=:firstname, password =: password where id = :id;")
    int update(@BindBean UserEntity user);

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("insert into users (lastname, firstname) values (:lastname, :firstname);")
    int insert(@BindBean UserEntity user);
}