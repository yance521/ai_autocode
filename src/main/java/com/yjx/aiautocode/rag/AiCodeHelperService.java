package com.yjx.aiautocode.rag;

import dev.langchain4j.service.SystemMessage;

public interface AiCodeHelperService {

    /**
     * 根据用户需求智能选择代码生成类型
     *
     * @param userPrompt 用户输入的需求描述
     * @return 推荐的代码生成类型结构化输出
     */
    @SystemMessage(fromResource = "prompt/codegen-routing-system-prompt.txt")
    String routeCodeGenType(String userPrompt);

}
