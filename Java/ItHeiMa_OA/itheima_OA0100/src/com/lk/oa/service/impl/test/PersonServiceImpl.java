package com.lk.oa.service.impl.test;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.PersonDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.test.Person;
import com.lk.oa.service.PersonService;
import com.lk.oa.service.base.impl.BaseServiceImpl;


@Component("personService")
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
	
	private PersonDao personDao;
	
	

	@Override
	public BaseDao<Person> getBaseDao() {
		
		return personDao ;
	}
	
	public PersonDao getPersonDao() {
		return personDao;
	}
	@Resource
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
}
