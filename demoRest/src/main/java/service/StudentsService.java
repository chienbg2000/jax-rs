package service;

import dao.ClassDao;
import dao.StudentDao;
import dto.StudentDTO;
import entity.StudentEntity;
import org.springframework.beans.BeanUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/students")
public class StudentsService {
    @GET
    @Path("/view")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentDTO> getAllStudents_JSON() {
        List<StudentEntity> listOfCountries = (ArrayList<StudentEntity>) StudentDao.getAllStudent();
        List<StudentDTO> dto = new ArrayList<StudentDTO>();
        for (StudentEntity st: listOfCountries ) {
            StudentDTO std = new StudentDTO();
            BeanUtils.copyProperties(st,std);
            std.setClassID(st.getClazzByClassId().getId());
            dto.add(std);
        }
        return dto;
    }
    @GET
    @Path("/view/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDTO getStudentJson(@PathParam("id")String id) {
        StudentDTO studentDTO = new StudentDTO();
        StudentEntity studentEntity = StudentDao.getStudent(id);
        BeanUtils.copyProperties(studentEntity, studentDTO);
        studentDTO.setClassID(studentEntity.getClazzByClassId().getId());
        return  studentDTO;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEmployee(@PathParam("id") String id) {
        StudentDao.deleteStudent(id);
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertStudent(StudentDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentDTO,studentEntity);
        studentEntity.setClazzByClassId(ClassDao.getClass(studentDTO.getClassID()));
        StudentDao.insertStudent(studentEntity);
    }

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String a(){
        return "oke";
    }
}
