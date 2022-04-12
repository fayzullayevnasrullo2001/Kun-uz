package com.company.dto;

import com.company.enums.ArticleStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDTO {
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;


    private Integer profileId;
    private Integer publisherId;

    private ArticleStatus status;

    private LocalDateTime createdDate;
    private LocalDateTime publishedDate;

    List<AttachDTO> attachList; //12,13,14,15

}
