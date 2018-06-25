import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class HibernateMain {
 
 public static void main(String[] args) {
    
  Configuration configuration=new Configuration();
  configuration.configure("hibernate.cfg.xml");
  ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
  SessionFactory sf=configuration.buildSessionFactory(sr);
  
  User user1=new User();
  user1.setUserName("thana");
  user1.setUserMessage("Hello world from thana");
  
  User user2=new User();
  user2.setUserName("kumares");
  user2.setUserMessage("Hello world from kumares");
  Session ss=sf.openSession();
  ss.beginTransaction();
 //saving objects to session
  ss.save(user1);
  ss.save(user2);
  ss.getTransaction().commit();
  ss.close();
  
 }
 
}