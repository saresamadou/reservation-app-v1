package aboudou.samadou.services.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matcher.*;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import aboudou.samadou.entities.Client;
import aboudou.samadou.metier.Metier;
import aboudou.samadou.services.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ClientServiceTest {

	private MockMvc mockMvc;
	
	@Autowired
	private Metier metierMock;
	
	@Before
	public void setUp() {
		ClientService restCtrl = new ClientService();
		
		metierMock = mock(Metier.class);
		ReflectionTestUtils.setField(restCtrl, "metier", metierMock);
		mockMvc = MockMvcBuilders.standaloneSetup(restCtrl).build();
	}
	
	@Test
	public void testGetAllClients() throws Exception{
		//Create client used for the test
		Client first = new Client("John", "doe", "FR 45 RUE", 55555L);
		Client second = new Client("Alice", "doe", "FR 45 RUE", 55555L);
		
		//Mock the metiermOCK's getAllClients method
		when(metierMock.getAllClients()).thenReturn(Arrays.asList(first, second));
		
		//test the service
		mockMvc.perform(get("/clients/getClients"))
		.andExpect(status().isOk())
		//.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
		.andExpect((ResultMatcher) jsonPath("$", org.hamcrest.Matchers.hasSize(2)));
		
	}

}
