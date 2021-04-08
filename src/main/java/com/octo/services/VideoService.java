package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoToVideoDTOMapper videoToVideoDTOMapper;


    public List<VideoDTO> retrieveVideosByTagAndLevel(List<String> tags, Level level) {

        // TODO code goes here
        // 1. search videos by tags AND/OR level don't use a simple @QUERY
        // 2. use videoToVideoDTOMapper to map videos to videos DTO
        // 3 return the list

        List<Video> videos;
        if ((tags == null || tags.isEmpty()) && level == null) {
            videos = videoRepository.findAll();
        } else if (tags == null || tags.isEmpty()) {
            videos = videoRepository.findDistinctByLevel(level);
        } else if (level == null) {
            videos = videoRepository.findDistinctByTagsIn(tags);
        } else {
            videos = videoRepository.findDistinctByTagsInOrLevel(tags, level);
        }
        List<VideoDTO> videosDto = new ArrayList<>();
        videos.forEach(video -> videosDto.add(videoToVideoDTOMapper.convert(video)));
        return videosDto;
    }


}
