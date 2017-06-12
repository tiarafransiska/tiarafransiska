/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jualbelihijab;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author tiara fransiska
 */
public class Queryhijab {
    
  public void Add(Object object) {
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JualbelihijabPU");
        EntityManager em = emf.createEntityManager();   
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
        
        }
    public void Show(){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JualbelihijabPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM hijab e");
        List<hijab> result = query.getResultList();
        for (hijab e : result) {
        System.out.println("__________________________________________________________________________________________________");
        System.out.println("No." +e.getId() 
                + " | Nama :"  +e.getNama() 
                + " | Alamat :"  +e.getAlamat() 
                + " | No.Telpon :"  +e.getNoTelpon() 
                + " | Merk motor :"  +e.getMerkhijab() 
                + " | ID User :"  +e.getIduser()
                + " | ");
        System.out.println("__________________________________________________________________________________________________");    
        }
    }
     public void update(long id,String a,String b,String c,String d,String e){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JualbelihijabPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE hijab e SET e.nama=?1,e.alamat=?2,e.NoTelpon=?3,e.Merkhijab=?4 WHERE e.Iduser?5",hijab.class)
                .setParameter(1, b)
                .setParameter(2, c)
                .setParameter(3, d)
                .setParameter(4, e)
                .setParameter(5, a)
                .executeUpdate();
        em.getTransaction().commit();
    }
     public void Delete(String a){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JualbelihijabPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String hapus = a;
        em.createQuery("DELETE FROM hijab e WHERE e.Iduser=:par").setParameter("par", hapus).executeUpdate();
        em.getTransaction().commit();
    }
}
