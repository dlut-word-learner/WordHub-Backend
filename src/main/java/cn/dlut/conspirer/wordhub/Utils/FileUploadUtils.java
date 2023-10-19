package cn.dlut.conspirer.wordhub.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * TODO
 * 负责检查上传文件的宽高比，转为固定大小的jpg并存储到对应位置
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
public class FileUploadUtils {
    private static boolean extensionAllowed(String extension, String[] allowedExtension) {
        return Arrays.asList(allowedExtension).contains(extension);
    }

    public static String upload(MultipartFile file, String pathName, String[] allowedExtension) throws IOException {
        log.info(pathName);
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if (allowedExtension != null && !extensionAllowed(extension, allowedExtension)) {
            return null;
        }
        File dest = new File(pathName);
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
