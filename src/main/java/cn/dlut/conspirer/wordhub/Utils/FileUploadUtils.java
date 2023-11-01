package cn.dlut.conspirer.wordhub.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;

/**
 * 将文件存入指定资源路径的工具类
 *
 * @author OuOu
 * @version 1.2
 */
@Slf4j
public class FileUploadUtils {
    private static boolean extensionAllowed(String extension, String[] allowedExtension) {
        return Arrays.asList(allowedExtension).contains(extension);
    }
    public static String upload(byte[] file, String pathName, String extension) throws IOException {
        File dest = new File(pathName+'.'+extension);
        log.info(dest.toString());
        File fileParent = dest.getParentFile();
        if (!fileParent.exists()) {
            fileParent.mkdirs();
        }
        dest.createNewFile();
        OutputStream stream = new FileOutputStream(dest);
        stream.write(file);
        return dest.getAbsolutePath();
    }

    public static String upload(MultipartFile file, String pathName, String[] allowedExtension) throws IOException {
        log.info("OriginalName: {}, ArgName: {}, ContentType: {}", file.getOriginalFilename(), file.getName(), file.getContentType());
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if(extension == null){
            String type = file.getContentType();
            if(type!=null)
                extension = switch (type) {
                    case "image/png" -> "png";
                    case "image/jpeg" -> "jpeg";
                    case "image/jpg" -> "jpg";
                    case "image/gif" -> "gif";
                    default -> extension;
                };
        }
        if (allowedExtension != null && !extensionAllowed(extension, allowedExtension)) {
            return null;
        }
        File dest = new File(pathName+'.'+extension);
        File fileParent = dest.getParentFile();
        if (!fileParent.exists()) {
            fileParent.mkdirs();
        }
        dest.createNewFile();
        file.transferTo(dest);
        return dest.getAbsolutePath();
    }

    public static String upload(MultipartFile file, String pathName) throws IOException {
        return upload(file, pathName, null);
    }
}
