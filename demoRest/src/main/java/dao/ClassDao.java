package dao;

import entity.ClassEntity;
import utils.HibernateUtils;

import javax.persistence.EntityManager;

public class ClassDao {
    public static ClassEntity getClass(String id){
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        ClassEntity cl =em.find(ClassEntity.class,id);
        em.getTransaction().commit();
        return cl;
    }

    public static void main(String[] args) {
        System.out.println(getClass("1810A01").getName());
    }
}
