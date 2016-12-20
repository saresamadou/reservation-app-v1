package aboudou.samadou.services.test;



import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Class to test the applications web services
 * @author absare
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarServiceTest {

	
	@Autowired
	private MockMvc  mockMvc;
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testGetCars() throws Exception  {
		this.mockMvc.perform(get("/cars/getCars")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testAddCar() throws Exception {
		this.mockMvc.perform(post("/cars/addCar")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.content").value( "You must give me a Car"));
	}
}
