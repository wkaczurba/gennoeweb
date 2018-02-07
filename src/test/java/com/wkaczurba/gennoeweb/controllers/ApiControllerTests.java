package com.wkaczurba.gennoeweb.controllers;

import com.wkaczurba.text.RandomText;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Normal (integration test...)
public class ApiControllerTests {

    @Mock
    RandomText randomTextMock;

    private final char[] response1 = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
    private MediaType contentType = MediaType.APPLICATION_JSON_UTF8;
    private MockMvc mockMvc;

    ApiController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(randomTextMock.getRandomChars()).thenReturn( response1 );

        controller = new ApiController(randomTextMock);
    }

    @Test
    public void testRequestMapping() throws Exception {
        // TODO: Mock RandomTextImpl...
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/generate"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(contentType))
                .andExpect(jsonPath("$.value", Is.is(new String(response1))));
    }
}
