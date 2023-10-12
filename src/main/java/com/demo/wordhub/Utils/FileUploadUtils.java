package com.demo.wordhub.Utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * 负责将上传的文件存储到对应位置
 *
 * @author OuOu
 * @version 1.0
 */
public class FileUploadUtils {
    private static boolean assertAllowed(String extension, String[] allowedExtension){
        return Arrays.asList(allowedExtension).contains(extension);
    }
    public static String upload(MultipartFile file, String pathName, String[] allowedExtension) throws IOException {
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if(allowedExtension!=null&&!assertAllowed(extension,allowedExtension)){
            return null;
        }
        File dest= new File(pathName+extension);
        file.transferTo(dest);
        return dest.getAbsolutePath();
    }
    public static String upload(MultipartFile file, String pathName) throws IOException {
        return upload(file, pathName, null);
    }
}
