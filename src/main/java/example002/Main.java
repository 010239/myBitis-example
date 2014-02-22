package example002;

import example002.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by DongZhukai on 14-2-24.
 */
public class Main {
    public static void main(String[] args) {
        String resource = "example002/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("User.selectUser",1);
            //System.out.println("user.getUserName()=" +  user.getUserName());
            //System.out.println("user.getPassword()=" +  user.getPassword());

            //插入操作
            User addUser = new User();
            addUser.setUserName("NEWWWWW");
            addUser.setPassword("111111");
            sqlSession.insert("User.addUser", addUser);

            //删除操作
            sqlSession.delete("User.deleteUser",26);

            User modifyUser = new User();
            modifyUser.setUserName("NEWWWWW");
            modifyUser.setPassword("111111");
            modifyUser.setId(1);
            //修改用户
            sqlSession.update("User.modifyUser", modifyUser);

            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
