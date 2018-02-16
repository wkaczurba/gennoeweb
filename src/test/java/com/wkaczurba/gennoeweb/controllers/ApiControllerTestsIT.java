package com.wkaczurba.gennoeweb.controllers;

import com.wkaczurba.gennoeweb.GennoewebApplication;
import com.wkaczurba.text.RandomText;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Integration test.

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GennoewebApplication.class)
@WebAppConfiguration // Spring MVC tests to run under WebApplicationContext, not ApplicationContext
public class ApiControllerTestsIT {

    @MockBean
    RandomText randomTextImpl;

    // Set media type to use JSON:
    private MediaType contentType = MediaType.APPLICATION_JSON_UTF8;

    private MockMvc mockMvc;
    private char[] response1 = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i' };

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(randomTextImpl.getRandomChars()).thenReturn(response1);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                   // .apply(springSecurity())
                   .build();

        // Setting up of all repositories in here...
    }

    @Test
    public void testRequestMapping() throws Exception {
        mockMvc.perform(get("/api/generate"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(contentType))
                .andExpect(jsonPath("$.value", Is.is(new String(response1))));
    }
}
