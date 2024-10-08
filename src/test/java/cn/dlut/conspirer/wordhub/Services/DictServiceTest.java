// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Mappers.DictMapper;
import cn.dlut.conspirer.wordhub.Services.Impls.DictServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@Slf4j
public class DictServiceTest {
    @Mock
    DictMapper dictMapper;

    @InjectMocks
    private DictService dictService = new DictServiceImpl(dictMapper);

    @Test
    void getAllDictionaries() {
        dictService.getAllDictionaries();
        verify(dictMapper).getDicts();
    }

    @Test
    void getDictionariesByLanguage() {
        Languages testLanguages = Languages.Test;
        dictService.getDictionariesByLanguage(testLanguages);
        verify(dictMapper).getDictsByLanguage(testLanguages);
    }

    @Test
    void getDictionaryById() {
        long testId = 0L;
        dictService.getDictionaryById(testId);
        verify(dictMapper).getDictById(testId);
    }

    @Test
    void getWordsToLearn() {
        long testDictId = 0, testUserId = 0, testNum = 100;
        dictService.getWordsToLearn(testDictId, testUserId, testNum);
        verify(dictMapper).getWordsToLearn(testDictId, testUserId, testNum);

    }

    @Test
    void addDict() {
        Languages testLanguages = Languages.Test;
        String testName = "testName";
        Dict testDict = new Dict(testLanguages, testName);
        dictService.addDict(testDict);
        verify(dictMapper).addDict(testDict);
    }
}
