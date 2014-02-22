package example004;

import example004.bean.Mobile;
import example004.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by DongZhukai on 14-2-24.
 */
public class Main {
    public static void main(String[] args) {
        String resource = "example004/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sqlSessionFactory.openSession();

            User user = sqlSession.selectOne("User.selectUser", 3);
            List<Mobile> mobiles = user.getMobiles();
            for(Mobile mobile : mobiles) {
                System.out.println("user:" + user.getUserName() + ",tel:" + mobile.getTelnumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
