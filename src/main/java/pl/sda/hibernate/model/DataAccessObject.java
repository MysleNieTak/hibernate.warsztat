package pl.sda.hibernate.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.HibernateUtil;

public class DataAccessObject <T>{

    // specyficzny typo obiektu, który służy do dostępu/zarządzania dostępem obiektów w bazie
    // instancja klasy, która umożliwia manipulowanie danymi w bazie


    public void insert (T obiektDoWstawieniaDoBazy){
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(obiektDoWstawieniaDoBazy);

            transaction.commit();

        } catch (Exception e){
            System.err.println("Błąd: "+ e);
        }
    }
}
