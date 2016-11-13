package test.com.jdbc.studentdemo.dao;

import com.jdbc.studentdemo.Student;
import com.jdbc.studentdemo.dao.DAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DAO Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ʮһ�� 6, 2016</pre>
 */
public class DAOTest {

    DAO dao = new DAO();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: update(String sql, Object ... args)
     */
    @Test
    public void testUpdate() throws Exception {
        String sql = "INSERT INTO UT VALUES(? ,?, ?)";

        dao.update(sql, "daotest", "jax", "13678875815");
    }

    /**
     * Method: delete(String sql)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: get(Class<T> clazz, String sql, Object ... args)
     */
    @Test
    public void testGet() throws Exception {
        String sql = "SELECT * FROM UT WHERE PHONENUMBER = ?";

        Student student = dao.get(Student.class, sql, "18363035273");
        System.out.println(student);
    }

    /**
     * Method: getForList(Class<T> clazz, String sql, Object ... args)
     */
    @Test
    public void testGetForList() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getForValue(String sql, Object ... args)
     */
    @Test
    public void testGetForValue() throws Exception {
//TODO: Test goes here... 
    }


} 
