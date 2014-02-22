package example001;

import example001.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

/**
 * Created by DongZhukai on 14-2-24.
 */
public class Main {
    public static void main(String[] args) {
        String resource = "example001/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("User.selectUser",1);
            System.out.println("user.getName()=" +  user.getName());
            System.out.println("user.getPass()=" +  user.getPass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
