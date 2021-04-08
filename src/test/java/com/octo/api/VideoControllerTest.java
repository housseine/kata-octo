package com.octo.api;


import com.octo.domain.enums.Level;
import com.octo.dto.video.VideoDTO;
import com.octo.holders.ApiPaths;
import com.octo.services.VideoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class VideoControllerTest {


    @InjectMocks
    VideoController videoController;
    @Mock
    VideoService videoService;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(videoController).build();
    }

    @Test
    public void getQuestionGroup_noTags_noLevel() throws Exception {
        List<VideoDTO> list = new ArrayList<>();
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setId("12345678");
        videoDTO.setLevel(Level.EASY);
        list.add(videoDTO);

        when(videoService.retrieveVideosByTagAndLevel(null, null)).thenReturn(list);

        mockMvc.perform(get(ApiPaths.V1 + ApiPaths.VIDEOS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].level", is(videoDTO.getLevel().name())));
    }

    @Test
    public void getQuestionGroup_noTags() throws Exception {
        List<VideoDTO> list = new ArrayList<>();
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setId("12345678");
        videoDTO.setLevel(Level.EASY);
        list.add(videoDTO);

        when(videoService.retrieveVideosByTagAndLevel(null, Level.EASY)).thenReturn(list);

        mockMvc.perform(get(ApiPaths.V1 + ApiPaths.VIDEOS + "?level=EASY"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].level", is(videoDTO.getLevel().name())));
    }

    @Test
    public void getQuestionGroup_noLevel() throws Exception {
        List<VideoDTO> list = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        tags.add("POURCENTAGE");
        tags.add("CALCUL");
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setId("12345678");
        videoDTO.setTags(tags);
        videoDTO.setLevel(Level.EASY);
        list.add(videoDTO);

        when(videoService.retrieveVideosByTagAndLevel(tags, null)).thenReturn(list);

        mockMvc.perform(get(ApiPaths.V1 + ApiPaths.VIDEOS + "?tags=POURCENTAGE&tags=CALCUL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].tags[0]", is("POURCENTAGE")));
    }

    @Test
    public void getQuestionGroup() throws Exception {
        List<VideoDTO> list = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        tags.add("POURCENTAGE");
        tags.add("CALCUL");
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setId("12345678");
        videoDTO.setTags(tags);
        videoDTO.setLevel(Level.MEDIUM);
        list.add(videoDTO);

        when(videoService.retrieveVideosByTagAndLevel(tags, Level.MEDIUM)).thenReturn(list);

        mockMvc.perform(get(ApiPaths.V1 + ApiPaths.VIDEOS + "?tags=POURCENTAGE&tags=CALCUL&level=MEDIUM"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].tags[0]", is("POURCENTAGE")));
    }

}