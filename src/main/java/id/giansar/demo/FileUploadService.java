package id.giansar.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {
    private static final Logger LOGGER = LoggerFactory.getLogger("FileUploadService");

    public void uploadFile(MultipartFile file) {
        try {
            Path destination = Paths.get(file.getOriginalFilename());
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
