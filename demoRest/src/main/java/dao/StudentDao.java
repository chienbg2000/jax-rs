package dao;

import entity.StudentEntity;
import utils.HibernateUtils;

import javax.persistence.*;

import java.util.List;

public class StudentDao {



    public static List<StudentEntity> getAllStudent(){
        EntityManager em = HibernateUtils.getEntityManager();
        Query query = em.createQuery("select c from StudentEntity c ");
        List<StudentEntity> resultList = query.getResultList();
        return resultList;
    }


    public static StudentEntity getStudent(String id){
        EntityManager em = HibernateUtils.getEntityManager();
        StudentEntity st = em.find(StudentEntity.class,id);
        return st;
    }

    public static void insertStudent(StudentEntity st){
        EntityManager em = HibernateUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(st);
        transaction.commit();
    }

    public static void deleteStudent(String id){
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        StudentEntity studentEntity = em.find(StudentEntity.class,id);
        em.remove(studentEntity);
        em.getTransaction().commit();
    }

    public static void upDateStudent(StudentEntity studentEntity){
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        StudentEntity st = em.find(StudentEntity.class,studentEntity.getId());
        st.setFullName(studentEntity.getFullName());
        em.getTransaction().commit();
    }


    public static void main(String[] args) {
        EntityManager em = HibernateUtils.getEntityManager();
    }
}
