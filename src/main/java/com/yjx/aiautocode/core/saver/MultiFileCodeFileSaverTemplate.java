package com.yjx.aiautocode.core.saver;

import cn.hutool.core.util.StrUtil;
import com.yjx.aiautocode.ai.model.CodeGenTypeEnum;
import com.yjx.aiautocode.ai.model.MultiFileCodeResult;
import com.yjx.aiautocode.exception.BusinessException;
import com.yjx.aiautocode.exception.ErrorCode;

/**
 * 多文件代码保存器
 *
 * @author YJX
 */
public class MultiFileCodeFileSaverTemplate extends CodeFileSaverTemplate<MultiFileCodeResult> {

    @Override
    public CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.MULTI_FILE;
    }

    @Override
    protected void saveFiles(MultiFileCodeResult result, String baseDirPath) {
        // 保存 HTML 文件
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
        // 保存 CSS 文件
        writeToFile(baseDirPath, "style.css", result.getCssCode());
        // 保存 JavaScript 文件
        writeToFile(baseDirPath, "script.js", result.getJsCode());
    }

    @Override
    protected void validateInput(MultiFileCodeResult result) {
        super.validateInput(result);
        // 至少要有 HTML 代码，CSS 和 JS 可以为空
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码内容不能为空");
        }
        if (StrUtil.isBlank(result.getCssCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "CSS代码内容不能为空");
        }
        if (StrUtil.isBlank(result.getJsCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "JS代码内容不能为空");
        }
    }
}
