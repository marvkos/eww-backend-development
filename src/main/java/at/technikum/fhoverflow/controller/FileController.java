package at.technikum.fhoverflow.controller;

import at.technikum.fhoverflow.dto.FileUploadResponse;
import at.technikum.fhoverflow.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public @ResponseBody FileUploadResponse upload(
        @RequestParam("file") MultipartFile file
    ) {
        String reference = fileService.upload(file);

        return new FileUploadResponse(
                true, reference
        );
    }
}
