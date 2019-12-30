package com.git.sqlsession;

import com.git.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

  @Test
  public void test1() throws IOException {
    String resource = "mybatis-sql-session.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    String statement = "com.git.mapper.UserMapper.orderby";

    //万能参数
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("ob", " order by birthday asc");

    List<User> userList = sqlSession.selectList(statement, map);
    for(User u:userList){
      System.out.println(u);
    }


  }
}
