import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.mtsbank.hw.config.WebConfig;

@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes = WebConfig.class)
public class CreatureControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateCreature() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/creature/api/add")
                        .content("{\"name\": \"Fluffy\", \"age\": 2, \"birthDate\": \"2022-03-10\", \"breed\": {\"type\": \"Cat\"}}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
