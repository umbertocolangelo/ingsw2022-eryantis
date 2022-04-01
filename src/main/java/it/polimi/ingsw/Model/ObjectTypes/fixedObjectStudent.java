package Model.ObjectTypes;

import java.util.*;

/**
 * 
 */
public interface fixedObjectStudent {

    /**
     * @param student
     */
    public void addStudent(Student student);

    /**
     * @param student
     */
    public void removeStudent(Student student);

    /**
     * @return
     */
    public ArrayList<Students> getStudents();

    /**
     * @return
     */
    public Int numOfStudents();

}