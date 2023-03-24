package us.peaksoft.gadgetarium.s3;

import com.amazonaws.services.s3.model.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class S3StorageController {
    private final S3Factory s3Factory;
    @GetMapping(path = "/buckets")
    public List<Bucket> getAllBucket(){
        return s3Factory.getAllBuckets();
    }
    @PostMapping(path = "/upload",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Map<String , String > uploadFile(@RequestPart(value = "file",required = false)MultipartFile file) throws IOException {
       s3Factory.uploadFile(file.getOriginalFilename(),file.getBytes());
       Map<String, String > result = new HashMap<>();
       result.put("key",file.getOriginalFilename());
       return result;
    }

    @GetMapping(path = "/download")
    public ResponseEntity<ByteArrayResource> uploadFile(@RequestParam(value = "file") String file) throws IOException{
        byte[] data = s3Factory.getFile(file);
        ByteArrayResource byteArrayResource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + file + "\"")
                .body(byteArrayResource);
    }
}
