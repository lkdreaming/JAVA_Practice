package cn.itcast.gyl.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.query.BaseQuery;
import cn.itcast.gyl.query.PageResult;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	private final Class<T> entityClass;
	
	private String identityName;
	
	public BaseDaoImpl() {
		 //获取泛型化的父类
		 ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		 //获取泛型运行期真实的类型
		 this.entityClass = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	public BaseDaoImpl(Class<T> entityClass){
		this.entityClass = entityClass;
	}

	@PostConstruct
	public void init(){
		this.identityName = this.hibernateTemplate.getSessionFactory()
				.getClassMetadata(this.entityClass).getIdentifierPropertyName();
	}
	
	@Override
	public void save(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void update(T t) {
		this.hibernateTemplate.update(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = get(id);
		if(t!=null){
			this.hibernateTemplate.delete(t);
		}
	}

	@Override
	public T get(Serializable id) {
		return this.hibernateTemplate.get(entityClass,id);
	}
	
	@Override
	public List query(final String hql,final Object[] params,final int start,final int limit) {
		List<Object> results = this.hibernateTemplate.execute(new HibernateCallback<List<Object>>() {
				@Override
				public List<Object> doInHibernate(Session session)throws HibernateException, SQLException {
					
					Query query = session.createQuery(hql);
					
					System.out.println(hql);
					
					//设置查询参数
					if(params!=null && params.length>0){
						for (int i = 0; i < params.length; i++) {
							query.setParameter(i,params[i]);
						}
						
					}
					//设置查询返回的起始行
					if(start>0){
						query.setFirstResult(start);
					}
					//设置查询返回结果的最大条数
					if(limit>0){
						query.setMaxResults(limit);
					}
					return query.list();
				}
			});
		return results;
	}

	@Override
	public List query(String hql, Object[] params) {
		return query(hql, params,-1,-1);
	}


	@Override
	public List<T> queryEntity(String condition, Object[] params, int start,int limit) {
		StringBuffer hql =new StringBuffer("SELECT obj FROM "+entityClass.getName()+" obj WHERE 1=1 ");
		//if(StringUtils.hasLength(condition)){
			if(!condition.startsWith("ORDER BY")){//如果不是以order by开始，则跟条件
				hql.append(" AND ").append(condition);
			}else{
				hql.append(" ").append(condition);//如果是以order by开始，则直接order by一个字段
			}
		//}
		return query(hql.toString(), params, start, limit);
	}

	@Override
	public List<T> queryEntity(String condition, Object[] params) {
		return queryEntity(condition, params,-1,-1);
	}

	@Override
	public <E> E uniqueResult(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int findCount(final BaseQuery baseQuery) {
		// select count(o) from Employee o where o.username like ? and o.email like ?
		final StringBuilder builder = new StringBuilder("select count(o) from " + entityClass.getName() + " o");
		String where = baseQuery.getWhere();
		// 有查询条件
		if (StringUtils.isNotBlank(where)) {
			builder.append(" where ").append(where);
		}
		System.out.println("PageResult findCount:" + builder.toString());

		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(builder.toString());
				// 设置查询条件的值
				List params = baseQuery.getParams();
				int index = 0;
				for (Object object : params) {
					query.setParameter(index++, object);
				}
				return ((Long) query.uniqueResult()).intValue();
			}
		});
	}
	
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		int count = findCount(baseQuery);
		if (count == 0) {
			return new PageResult<T>();
		}
		
		final PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), count);
		// select o from Employee o where o.username like ? and o.email like ?
		final StringBuilder builder = new StringBuilder("select o from " + entityClass.getName() + " o");
		String where = baseQuery.getWhere();
		// 有查询条件
		if (StringUtils.isNotBlank(where)) {
			builder.append(" where ").append(where);
		}
		System.out.println("PageResult findPageResult:" + builder.toString());

		List<T> rows = this.hibernateTemplate.execute(new HibernateCallback<List<T>>() {
			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(builder.toString());
				// 设置查询条件的值
				List params = baseQuery.getParams();
				// 索引jdbc:1,hibernate:0
				// for (int i = 0; i < params.size(); i++) {
				// query.setParameter(i, params.get(i));
				// }
				int index = 0;
				for (Object object : params) {
					query.setParameter(index++, object);
				}
				// 设置分页的信息
				// select o from Employee o limit 0,10
				// baseQuery里面的查询条件是有可能是有问题的
				// 必须使用做了错误处理后的pageResult
				int first = (pageResult.getCurrentPage() - 1) * pageResult.getPageSize();
				int max = pageResult.getPageSize();
				query.setFirstResult(first).setMaxResults(max);
				return query.list();
			}
		});
		pageResult.setRows(rows);
		return pageResult;
	}

	@Override
	public Long getMaxId() {
		ClassMetadata classMetadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(entityClass);
		Long identity = (Long)this.hibernateTemplate.find("select count("+classMetadata.getIdentifierPropertyName()+") from "+entityClass.getName()).get(0);
		if(identity==null){
			return 1L;
		}else{
			return identity+1;
		}
	}

	@Override
	public T getEntry_Zhu(Serializable ddh) {
		return (T)this.hibernateTemplate.find("from "+entityClass.getName()+" where ddh=?",ddh).get(0);
	}
	
	@Override
	public T getEntry_Zhi(Serializable hh) {
		return (T)this.hibernateTemplate.find("from "+entityClass.getName()+" where hh=?",hh).get(0);
	}
}
