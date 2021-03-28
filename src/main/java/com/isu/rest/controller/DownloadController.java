package com.isu.rest.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class DownloadController {

    @GetMapping("/a")
    public String getA() {
        return "A";
    }

//    @GetMapping(value = "/image")
//    public byte[] getImage(HttpServletResponse response) throws IOException {
//        response.addHeader("Content-Disposition", "attachment");
//        InputStream in = getClass()
//                .getResourceAsStream("/static/a.png");
//        return IOUtils.readAllBytes(in);
//    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String param) throws IOException {
        File file = new File(getClass().getResource("/static/a.png").getFile());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=myDoc.png");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


}
