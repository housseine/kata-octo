package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VideoServiceTest {


    @InjectMocks
    private VideoService videoService;
    @Mock
    private VideoRepository videoRepository;
    @Mock
    private VideoToVideoDTOMapper videoToVideoDTOMapper;
    List<Video> list;
    Video video;
    List<String> tags;
    List<VideoDTO> videoDtos;
    VideoDTO videoDto;
    @Before
    public void setUp() {
        list = new ArrayList<>();
        video = new Video();
        video.setId("12345678");
        video.setLevel(Level.EASY);
        tags = new ArrayList<>();
        tags.add("POURCENTAGE");
        tags.add("CALCUL");
        video.setTags(tags);
        list.add(video);

        videoDtos = new ArrayList<>();
        videoDto = new VideoDTO();
        videoDto.setId("12345678");
        videoDto.setLevel(Level.EASY);
        videoDto.setTags(tags);
        videoDtos.add(videoDto);
    }

    @Test
    public void retrieveVideoByTagsAndOrLevelWithNoTagsAndNoLevel_test() {
        when(videoRepository.findAll()).thenReturn(list);
        when(videoToVideoDTOMapper.convert(video)).thenReturn(videoDto);

        List<VideoDTO> resultVideoDtos = videoService.retrieveVideosByTagAndLevel(null, null);

        assertEquals("EASY", resultVideoDtos.get(0).getLevel().name());
    }

    @Test
    public void retrieveVideoByTagsAndOrLevelWithNullTags_test() {
        when(videoRepository.findDistinctByLevel(Level.EASY)).thenReturn(list);
        when(videoToVideoDTOMapper.convert(video)).thenReturn(videoDto);

        List<VideoDTO> resultVideoDtos = videoService.retrieveVideosByTagAndLevel(null, Level.EASY);

        assertEquals("EASY", resultVideoDtos.get(0).getLevel().name());
    }

    @Test
    public void retrieveVideoByTagsAndOrLevelWithNullLevel_test_() {
        when(videoRepository.findDistinctByTagsIn(tags)).thenReturn(list);
        when(videoToVideoDTOMapper.convert(video)).thenReturn(videoDto);

        List<VideoDTO> resultVideoDtos = videoService.retrieveVideosByTagAndLevel(tags, null);

        assertEquals("EASY", resultVideoDtos.get(0).getLevel().name());
    }
    @Test
    public void retrieveVideoByTagsAndOrLevel_test() {
        when(videoRepository.findDistinctByTagsInOrLevel(tags,Level.EASY)).thenReturn(list);
        when(videoToVideoDTOMapper.convert(video)).thenReturn(videoDto);

        List<VideoDTO> resultVideoDtos = videoService.retrieveVideosByTagAndLevel(tags, Level.EASY);

        assertEquals("EASY", resultVideoDtos.get(0).getLevel().name());
    }

    @Test
    public void retrieveVideoByTagsAndOrLevelWithEmptyTags_test() {
        when(videoRepository.findDistinctByLevel(Level.EASY)).thenReturn(list);
        when(videoToVideoDTOMapper.convert(video)).thenReturn(videoDto);

        List<VideoDTO> resultVideoDtos = videoService.retrieveVideosByTagAndLevel(new ArrayList<>(), Level.EASY);
        assertEquals("EASY", resultVideoDtos.get(0).getLevel().name());
    }
}