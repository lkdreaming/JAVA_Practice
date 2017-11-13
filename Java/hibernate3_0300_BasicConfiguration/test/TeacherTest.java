import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lk.hibernate.model.Teacher;
import com.lk.hibernate.model.ZhiCheng;


public class TeacherTest {
	private static SessionFactory sf = null;
	@BeforeClass
	public static void beforeClass() {
		try {
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testTeacherSave() {
		Teacher t = new Teacher();
		t.setId(4);
		t.setName("t4");
		t.setTitle("ÌØ¼¶");
		t.setBirthday(new Date());
		t.setZhicheng(ZhiCheng.B);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
}
