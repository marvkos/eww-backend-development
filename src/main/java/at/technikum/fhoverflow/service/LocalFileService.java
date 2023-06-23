package at.technikum.fhoverflow.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class LocalFileService implements FileService {

    @Override
    public String upload(MultipartFile file) {
        // TODO: Implement
        Path uploadPath = Paths.get(
                "images/",
                UUID.randomUUID() + "_" + file.getOriginalFilename()
        );

        try {
            Files.copy(file.getInputStream(), uploadPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "null";
    }

    @Override
    public Resource get(String reference) {
        return null;
    }
}
