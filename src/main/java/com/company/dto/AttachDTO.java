package com.company.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Setter
@Getter
public class AttachDTO {
    private Integer id;
    private String key;
    private String originName;
    private Long size;
    private String filePath;
    private String extension;
    private LocalDateTime createdDate;
    private String url;
}
