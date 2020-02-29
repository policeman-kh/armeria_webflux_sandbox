package sandbox.armeria;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @GetMapping(value = "/get-image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] test2() {
        return getImageBytes();
    }

    private static byte[] getImageBytes() {
        try {
            return Files.readAllBytes(new File("jpg.jpg").toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
