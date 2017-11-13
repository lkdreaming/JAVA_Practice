package cn.itcast.gyl.dao.impl.test;

import org.springframework.stereotype.Repository;

import cn.itcast.gyl.dao.base.impl.BaseDaoImpl;
import cn.itcast.gyl.dao.test.PersonDao;
import cn.itcast.gyl.domain.test.Person;

@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao{

}
