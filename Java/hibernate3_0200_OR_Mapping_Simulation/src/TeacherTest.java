import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.lk.hibernate.model.Teacher;

public class TeacherTest {
	
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setId(2);
		t.setName("t2");
		t.setTitle("¶þ¼¶");
		
		Configuration cf = new AnnotationConfiguration();
		SessionFactory sf = cf.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save( t );
		session.getTransaction().commit();
		session.close();
	}
}






	
	


