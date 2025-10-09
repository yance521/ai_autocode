package com.yjx.aiautocode.core;

import com.yjx.aiautocode.ai.model.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class AiCodeGeneratorFacadeOldTest {
    @Resource
    private AiCodeGeneratorFacade_old aiCodeGeneratorFacadeOld;

    @Test
    void generateAndSaveCode() {
        File file = aiCodeGeneratorFacadeOld.generateAndSaveCode("生成一个简单的任务记录网站", CodeGenTypeEnum.HTML);
        Assertions.assertNotNull(file);
    }
}