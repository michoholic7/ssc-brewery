package guru.sfg.brewery.web.controllers.api;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IndexControllerIT extends BaseIT {
    @Test
    @SneakyThrows
    void testGetIndexSlash() {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
