package com.demo.wordhub.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

// 不指定classes的话会引入整个SpringBoot上下文，拖慢速度。
// 也可以直接不使用SpringBootTest，但这样就无法依赖注入ResourceLoader和avatarPath，需要手动读取资源文件并mock avatarPath配置类
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {FileUploadUtils.class})
class FileUploadUtilsTest {
    private final ResourceLoader resourceLoader;

    @Value("${urls.avatar}")
    private String avatarPath;

    @Autowired
    FileUploadUtilsTest(ResourceLoader rl) {
        this.resourceLoader = rl;
    }

    @Test
    void testUpload() throws IOException {
        MockMultipartFile avatar = new MockMultipartFile("test_avatar.jpg", resourceLoader.getResource("classpath:test_avatar.jpg").getInputStream());
        String path = FileUploadUtils.upload(avatar, avatarPath + avatar.getName());
        Assertions.assertNotNull(path);
    }
}