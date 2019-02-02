/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Pointage;
import dao.IDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author dell
 */
public class PointageService implements IDao<Pointage> {

    @Override
    public boolean create(Pointage o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return false;
        }
    }

    public boolean createAll(List<Pointage> os) {
        HibernateUtil.getSessionFactory().openSession().setFlushMode(FlushMode.MANUAL);
        final Session session = HibernateUtil.getSessionFactory().openSession();
        final Transaction tx = session.beginTransaction();;
        try {
            os.forEach((e) -> {
                session.save(e);
            });
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            System.out.println("error message :" + ex.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return false;
        }
    }

    @Override
    public boolean update(Pointage o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return false;
        }
    }

    @Override
    public boolean delete(Pointage o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return false;
        }
    }

    @Override
    public Pointage findById(int id) {
        Pointage m = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            m = (Pointage) session.get(Pointage.class, id);
            tx.commit();
            session.close();
            return m;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return m;
        }
    }

    @Override
    public List<Pointage> findAll() {
        List<Pointage> Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createQuery("from Pointage").list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public List<Pointage> findPointagebyEmploye(int id) {
        List<Pointage> Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createQuery("SELECT p FROM Pointage p Where p.employe.id = ? ").setParameter(0, id).list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public List<Pointage> findPointagesBetweenDates(int id, Date d1, Date d2) {
        List<Pointage> Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createQuery("SELECT p FROM Pointage p Where p.employe.id = ? and p.date BETWEEN ? and ?").setParameter(0, id).setParameter(1, d1).setParameter(2, d2).list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public int beforeLastPointage(int id) {
        int Profils = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = Integer.parseInt(session.createSQLQuery("SELECT id FROM pointage WHERE employe_id = ? ORDER BY id DESC LIMIT 1,1").setParameter(0, id).uniqueResult().toString());
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public int lastPointage(int id) {
        int Profils = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = Integer.parseInt(session.createSQLQuery("SELECT id FROM pointage WHERE employe_id = ? ORDER BY id DESC LIMIT 1").setParameter(0, id).uniqueResult().toString());
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public List<Pointage> findPointageSortie() {
        List<Pointage> Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createQuery("SELECT p FROM Pointage p Where p.etat = 'sortie' ").list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public List<Pointage> findPointagebyEmployeSortie(int id) {
        List<Pointage> Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createQuery("SELECT p FROM Pointage p Where p.etat = 'sortie' and p.employe.id = ? ").setParameter(0, id).list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public List lastTwoPointages() {
        List Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createSQLQuery("SELECT * FROM Pointage p limit 0,2").list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public List totalHeure() {
        List Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createSQLQuery("select p.date ,e.nom,e.prenom,SUM(p.nbrHeure),SUM(p.nbrMinute) FROM pointage p, employe e WHERE e.id=p.employe_id GROUP BY p.employe_id , DAY(p.date) order by p.date desc").list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public List totalHeurebyEmploye(int id) {
        List Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createSQLQuery("select p.date ,e.nom,e.prenom,SUM(p.nbrHeure),SUM(p.nbrMinute) FROM pointage p, employe e WHERE e.id=p.employe_id and e.id = ? GROUP BY p.employe_id , DAY(p.date) order by p.date desc").setParameter(0, id).list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public List totalHeurebyEmployebetweenDates(int id, Date d1, Date d2) {
        List Profils = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = session.createSQLQuery("select p.date ,e.nom,e.prenom,SUM(p.nbrHeure),SUM(p.nbrMinute) FROM pointage p, employe e WHERE e.id=p.employe_id and e.id = ? and p.date between ? and ? GROUP BY p.employe_id , DAY(p.date) order by p.date desc").setParameter(0, id).setParameter(1, d1).setParameter(2, d2).list();
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public int count() {
        int Profils = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = Integer.parseInt(session.createSQLQuery("select count(*) from Pointage").uniqueResult().toString());
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

     public int totalHeurebyMonth(int id, int m) {
        int Profils  = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils =  Integer.parseInt(session.createSQLQuery("SELECT COALESCE(SUM(nbrHeure),0) FROM Pointage WHERE employe_id = ? and MONTH(date) = ?").setParameter(0, id).setParameter(1, m).uniqueResult().toString());
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }
     
     public int totalMinutebyMonth(int id, int m) {
        int Profils  = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils =  Integer.parseInt(session.createSQLQuery("SELECT COALESCE(SUM(nbrMinute),0) FROM Pointage WHERE employe_id = ? and MONTH(date) = ?").setParameter(0, id).setParameter(1, m).uniqueResult().toString());
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }
    public int totalHeurebyYear(int id, int h) {
        int Profils  = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils =  Integer.parseInt(session.createSQLQuery("SELECT COALESCE(SUM(nbrHeure),0) FROM Pointage WHERE employe_id = ? and YEAR(date) = ?").setParameter(0, id).setParameter(1, h).uniqueResult().toString());
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }
    
    public int totalMinutebyYear(int id, int h) {
        int Profils  = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils =  Integer.parseInt(session.createSQLQuery("SELECT COALESCE(SUM(nbrMinute),0) FROM Pointage WHERE employe_id = ? and YEAR(date) = ?").setParameter(0, id).setParameter(1, h).uniqueResult().toString());
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }

    public Integer nbrHeure(String d1, String d2) {
        int Profils = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Profils = Integer.parseInt(session.createSQLQuery("SELECT TIMESTAMPDIFF(hour ,' ? ',' ? ' )").setParameter(0, d1).setParameter(1, d2).uniqueResult().toString());
            tx.commit();
            session.close();
            return Profils;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return Profils;
        }
    }
}
