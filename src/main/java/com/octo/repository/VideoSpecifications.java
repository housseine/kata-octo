package com.octo.repository;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.domain.video.Video_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.List;

public class VideoSpecifications {

    public static Specification<Video> finVideoByLevelOrTags(Level level, List<String> tags) {
        if (level == null && tags.isEmpty()) return null;
        return
                (root, query, cb) -> {
                    Predicate predicate = cb.equal(root.get(Video_.level), level);
                    for (String tag : tags) {
                        Predicate predicateTemp = cb.isMember(tag, root.get(Video_.tags));
                        predicate = cb.or(predicate, predicateTemp);
                    }
                    return predicate;

                };

    }


}
