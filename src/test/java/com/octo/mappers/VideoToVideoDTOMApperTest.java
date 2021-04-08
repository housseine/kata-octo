package com.octo.mappers;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VideoToVideoDTOMApperTest {
    @InjectMocks
    VideoToVideoDTOMapper videoToVideoDTOMapper;

    @Test
    public void convertVideoToVideoDTO(){
        Video video= new Video();
        video.setLevel(Level.MEDIUM);
        List<String>tags= new ArrayList<>();
        tags.add("POURCENTAGE");
        tags.add("CALCUL");
        video.setTags(tags);
        video.setId("12345678");
        VideoDTO videoDTO= videoToVideoDTOMapper.convert(video);
        assertNotNull(videoDTO);
        assertEquals(video.getLevel(),videoDTO.getLevel());
    }
    @Test
    public void notConvertVideoToVideoDTOAndReturnNull(){
        Video video= null;
        VideoDTO videoDTO= videoToVideoDTOMapper.convert(video);
        assertNull(videoDTO);
    }
}
