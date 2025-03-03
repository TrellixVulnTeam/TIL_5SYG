package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j
public class DatasourceTests {
	
	

	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactory;

	
	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;
	

	@Test
	public void testMyBatis() {
		try (SqlSession session = sqlSessionFactory.openSession(); 
				Connection con = session.getConnection();) {
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
//	@Test
//	public void testConnection() {
//		try (Connection con = dataSource.getConnection()) {
//			log.info(con);
//		} catch (Exception e) {
//			fail(e.getMessage());
//		}
//	}
}
