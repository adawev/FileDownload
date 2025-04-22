package diyor.adawev.filedownload.service;

import diyor.adawev.filedownload.model.FileEntity;
import diyor.adawev.filedownload.repo.FileEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    @Autowired
    FileEntityRepo fileEntityRepo;

    public FileEntity create(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(file.getName());
        fileEntity.setType(file.getContentType());
        fileEntity.setFileData(file.getBytes());
        return fileEntityRepo.save(fileEntity);
    }

    public FileEntity getFileById(Long id) {
        return fileEntityRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("File Not Found"));
    }
}
