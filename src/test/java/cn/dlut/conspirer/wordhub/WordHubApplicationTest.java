// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 集成测试，测试上下文环境能否正常加载
 */
@SpringBootTest(classes = WordHubApplication.class)
class WordHubApplicationTest {

    @Test
    void contextLoads() {
    }

}
