package com.KNUT_CLUB_Test.domain.notice;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FileDto {
    private String uuid;
    private String uploadPath;
    private String fileName;
    private String contentType;

    public FileDto(String uuid,String fileName, String contentType) {
        this.uuid = uuid;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public FileDto(String num, String uploadPath, String fileName, String contentType) {
        this.uuid = num;
        this.uploadPath = uploadPath;
        this.fileName = fileName;
        this.contentType = contentType;
    }
}
