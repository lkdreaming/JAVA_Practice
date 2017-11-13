import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.lk.hibernate.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Student s = new Student();
		s.setId(3);
		s.setName("s3");
		s.setAge(3);

		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
