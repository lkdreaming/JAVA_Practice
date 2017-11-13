package com.lk.oa.dao.impl.test;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lk.oa.dao.PersonDao;
import com.lk.oa.dao.base.impl.BaseDaoImpl;
import com.lk.oa.model.test.Person;

@Component("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {

}
