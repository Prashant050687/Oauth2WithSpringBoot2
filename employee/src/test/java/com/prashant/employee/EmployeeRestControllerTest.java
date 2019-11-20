package com.prashant.employee;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.prashant.employee.exception.RestExceptionHandler;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

import org.apache.commons.lang3.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@DirtiesContext
public class EmployeeRestControllerTest {

	  private MockMvc mockMvc;

	  @Autowired
	  private WebApplicationContext context;
	  
	  @Before
	  public void setUp() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	  }
	  
	  @Test
	  @SuppressWarnings({ "PMD.JUnitTestsShouldIncludeAssert", "deprecation" })
	  public void findEmployee() throws Exception {
	    mockMvc.perform(get("/employee/1")
	      .content(StringUtils.EMPTY))
	      .andExpect(status().isForbidden())
	      .andExpect(content().contentType(RestExceptionHandler.APPLICATION_ERROR_JSON))
	      .andExpect(jsonPath("$.title", is("Access Denied - You do not have permission to access the operation")));
	  }
}
