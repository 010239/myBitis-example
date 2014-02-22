package example003;

import example003.bean.Mobile;
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
        String resource = "example003/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sqlSessionFactory.openSession();

            Mobile mobile = sqlSession.selectOne("Mobile.selectMobile",2);
            System.out.println(mobile.getId() + " " + mobile.getTelnumber() + " " +
                    mobile.getUser().getId() + " " + mobile.getUser().getUserName());
        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
