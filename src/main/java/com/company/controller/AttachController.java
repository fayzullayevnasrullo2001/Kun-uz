package com.company.controller;

import com.company.dto.AttachDTO;
import com.company.service.AttachService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/attach")
@Api(tags = "Attach")
public class AttachController {
    @Autowired
    private AttachService attachService;

    @PostMapping("/upload")
    public ResponseEntity<AttachDTO> fileUpload(@RequestParam("file") MultipartFile file) {
        AttachDTO fileName = attachService.saveFile(file);
        return ResponseEntity.ok().body(fileName);
    }

    @GetMapping(value = "/get/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("fileName") String fileName) {
        if (fileName != null && fileName.length() > 0) {
            try {
                return this.attachService.loadAttach(fileName);
            } catch (Exception e) {
                e.printStackTrace();
                return new byte[0];
            }
        }
        return null;
    }

    @GetMapping(value = "/loadGeneral/{fileName}", produces = MediaType.ALL_VALUE)
    public byte[] loadGeneral(@PathVariable("fileName") String fileName) {
        if (fileName != null && fileName.length() > 0) {
            try {
                return this.attachService.loadGeneral(fileName);
            } catch (Exception e) {
                e.printStackTrace();
                return new byte[0];
            }
        }
        return null;
    }

    @GetMapping("/load/{fineName}")
    public ResponseEntity<Resource> loadFile(@PathVariable("fineName") String fileToken) {
        Resource file = attachService.load(fileToken);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @DeleteMapping("/{key}")
    public ResponseEntity<Resource> deleteFile(@PathVariable("key") String fileToken) {
        attachService.delete(fileToken);
        return ResponseEntity.ok().build();
    }

}
