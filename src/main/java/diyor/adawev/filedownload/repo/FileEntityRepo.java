package diyor.adawev.filedownload.repo;

import diyor.adawev.filedownload.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepo extends JpaRepository<FileEntity, Long> {
}
