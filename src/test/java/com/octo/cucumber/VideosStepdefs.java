package com.octo.cucumber;

import com.octo.domain.enums.Level;
import com.octo.dto.video.VideoDTO;
import com.octo.services.VideoService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VideosStepdefs {
    List<String> tags;
    String level;
    List<VideoDTO> videoDTOS;
    @Autowired
    VideoService videoService = new VideoService();

    @When("I Call the service RetrieveVideosByTagAndLevel")
    public void i_ask_whether_it_s_Friday_yet() {
        Level levelObject;
        if (level == null) {
            levelObject = null;
        } else {
            levelObject = Level.valueOf(level);
        }
        videoDTOS = videoService.retrieveVideosByTagAndLevel(tags, levelObject);
    }

    @Then("I should get {int} videos")
    public void i_should_be_told(int number) {
        Assert.assertEquals(number, videoDTOS.size());

    }

    @Given("level {string} tags")
    public void todayIsSunday(String arg0, DataTable testData) {
        this.tags = testData.asList(String.class);
        level = arg0;
    }

    @Given("no level and no tags")
    public void noLevelAndNoTags() {
        level = null;
        tags = null;
    }

    @Given("tags")
    public void tags(DataTable testData) {
        tags = testData.asList(String.class);
    }

    @Then("I should get one {int} video")
    public void iShouldGetOneVideo(int number) {
        Assert.assertEquals(number, videoDTOS.size());
    }

    @Given("level {string}")
    public void level(String arg0) {
        level = arg0;
    }
}
