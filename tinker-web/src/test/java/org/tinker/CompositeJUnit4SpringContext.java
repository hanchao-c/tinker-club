package org.tinker;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
@WebAppConfiguration
public class CompositeJUnit4SpringContext extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
