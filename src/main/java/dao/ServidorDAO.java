package dao;
import jakarta.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import java.util.List;

public class ServidorDAO {
    private static Transaction tx = null;
    private static Session session = null;

    public static void create(Object object, boolean autocommit) throws Exception {
        try {
            if (autocommit == true) {
                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();
                session.persist(object);
                tx.commit();
                session.close();
            } else {
                session.persist(object);
            }
        } catch (HibernateException he) {
            he.printStackTrace();
            if (tx != null) {
//                tx.rollback();
            }
            session.close();
            throw he;
        }
    }
    public static void create(Object object) throws Exception {
        create(object, true);
    }

    public static Object update(Object object, Boolean autocommit) throws Exception {
        try {
            if (autocommit == true) {
                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();
                object = session.merge(object);
                tx.commit();
                session.close();
            } else {
                object = session.merge(object);
            }
            return object;
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            throw he;
        }
    }

    public static Object update(Object object) throws Exception {
        return update(object, true);
    }
    public static List<Object> readList(Object hql) {
        return readList(hql,true);
    }
    public static List<Object> readList(Object hql,boolean autocommit) {
        List<Object> results=null;
        Query<Object> query=null;
        try {
            if (autocommit == true) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                query = session.createQuery((String) hql, Object.class);
                results = query.getResultList();
                session.close();
            }else{
                query = session.createQuery((String) hql, Object.class);
                results = query.getResultList();
            }
            return results;
        } catch (NoResultException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Object readObject(Object hql) {
        return readObject(hql,true);
    }

    public static Object readObject(Object hql,boolean autocommit) {
        Object results=null;
        Query<Object> query=null;
        try{
            if (autocommit) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                query = session.createQuery((String) hql, Object.class);
                results = query.getSingleResult();
                session.close();
            }
            else{
                query = session.createQuery((String) hql, Object.class);
                results = query.getSingleResult();
            }
            return results;
        } catch (NoResultException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void remove(Object object, boolean autocommit) throws Exception {
        try {
            if (autocommit == true) {
                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();
                session.remove(object);
                tx.commit();
                session.close();
            } else {
                session.remove(object);
            }
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            throw he;
        }
    }

    public static void remove(Object object) throws Exception {
        remove(object, true);
    }

    public static void transaction() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            throw he;
        }
    }

    public static void commit() throws Exception {
        try {
            tx.commit();
            session.close();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            throw he;
        }
    }
}