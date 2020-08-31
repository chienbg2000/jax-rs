package dao;

import entity.ClassDTO;
import utils.HibernateUtils;

import javax.persistence.EntityManager;

public class ClassDao {
    public static ClassDTO getClass(String id){
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        ClassDTO cl =em.find(ClassDTO.class,id);
        em.getTransaction().commit();
        return cl;
    }

    public static void main(String[] args) {
        System.out.println(getClass("1810A01").getName());
    }
}
