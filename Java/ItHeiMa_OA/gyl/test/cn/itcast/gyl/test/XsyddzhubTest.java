package cn.itcast.gyl.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import cn.itcast.gyl.domain.xsgl.Xsyddzhub;
import cn.itcast.gyl.xsgl.service.XsyddService;

public class XsyddzhubTest {
	@Test
	public void test() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/gyl/spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Xsyddzhub xsyddzhub = (Xsyddzhub)session.get(Xsyddzhub.class, 1L);
//		Date date = new Date();
//		xsyddzhub.setDhrq(date);
//		transaction.commit();
		/**
		 * 总结：
		 *    当映射文件设置成date类型时，数据库只能存储到天级别的数据
		 *    这个时候用条件查询，则
		 *    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
				query.setDate(0, simpleDateFormat.parse("2014-03-08 00:00:00"));
			 当映射文件设置成timestamp类型时，数据库存储到秒的级别
			   这个时候条件查询，则
			   	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
				query.setTimeStamp(0, simpleDateFormat.parse("2014-03-08 23:13:50"));
		 */
		Query query = session.createQuery("from Xsyddzhub where dhrq=?");
		//System.out.println(new Date());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		//query.setDate(0, simpleDateFormat.parse("2014-03-08 00:00:00"));
		query.setParameter(0, simpleDateFormat.parse("2014-03-08 00:00:00"));
		System.out.println(query.list().size());
		session.close();
	}
}
