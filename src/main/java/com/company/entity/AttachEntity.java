package com.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "attach")
public class AttachEntity extends BaseEntity {
    @Column(name = "key")
    private String key; //8b19f7d6-5a8e-4209-8303-139bc6667837
    @Column(name = "origin_name")
    private String originName;
    @Column(name = "size")
    private Long size;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "extension")
    priv3210ate String extension;
}
