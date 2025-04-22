package diyor.adawev.filedownload.controller;

import diyor.adawev.filedownload.model.FileEntity;
import diyor.adawev.filedownload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file")MultipartFile file) {
        try {
            fileService.create(file);
            return ResponseEntity.ok("Rasm muvaffaqiyatli yuklandi.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Xatolik" + e.getMessage());
        }
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {
        FileEntity fileById = fileService.getFileById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileById.getName())
                .contentType(MediaType.IMAGE_PNG)
                .body(fileById.getFileData());
    }
}