package com.example.dao;

import com.example.core.Person;
import com.example.core.mapper.PersonMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.Bind;
import org.jdbi.v3.sqlobject.statement.Define;

import java.util.List;

@RegisterRowMapper(PersonMapper.class)
public interface PersonDAO {

    @SqlQuery("select * from PERSON")
    List<Person> getAll();

    @SqlQuery("select * from PERSON where ID = :id")
    Person findById(@Bind("id") int id);

    @SqlUpdate("delete from PERSON where ID = :id")
    int deleteById(@Define("id") int id);

    @SqlUpdate("update PERSON set NAME = :name where ID = :id")
    int update(@BindBean Person person);

    @SqlUpdate("insert into PERSON (ID, NAME) values (:id, :name)")
    int insert(@BindBean Person person);
}
