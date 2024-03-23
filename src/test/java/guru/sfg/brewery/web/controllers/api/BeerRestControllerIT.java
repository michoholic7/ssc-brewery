package guru.sfg.brewery.web.controllers.api;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BeerRestControllerIT extends BaseIT {
    @Test
    @SneakyThrows
    void findBeers() {
        mockMvc.perform(get("/api/v1/beer/"))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void findBeersById() {
        mockMvc.perform(get("/api/v1/beer/97df0c39-98c4-4ae0-b663-453e8e19c311"))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void findBeerByUpc() {
        mockMvc.perform(get("/api/v1/beerUpc/063123420036"))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void initCreationFormUser() {
        mockMvc.perform(get("/beers/new").with(httpBasic("user","password")))
                 .andExpect(status().isOk())
                .andExpect(view().name("beers/createBeer"))
                .andExpect(model().attributeExists("beer"));
    }

    @Test
    @SneakyThrows
    void initCreationFormMo() {
        mockMvc.perform(get("/beers/new").with(httpBasic("mo","LulaWisam")))
                .andExpect(status().isOk())
                .andExpect(view().name("beers/createBeer"))
                .andExpect(model().attributeExists("beer"));
    }
}
