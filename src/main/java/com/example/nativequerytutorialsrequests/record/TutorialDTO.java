package com.example.nativequerytutorialsrequests.record;

import java.util.Date;

public record TutorialDTO(Long id,
                          String title,
                          String description,
                          int level,
                          boolean published,
                          Date createdAt
) {

}
