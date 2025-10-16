package com.yjx.aiautocode.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.yjx.aiautocode.model.dto.app.AppAddRequest;
import com.yjx.aiautocode.model.dto.app.AppQueryRequest;
import com.yjx.aiautocode.model.entity.App;
import com.yjx.aiautocode.model.entity.User;
import com.yjx.aiautocode.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;


/**
 * 应用 服务层。
 *
 * @author YJX
 */
public interface AppService extends IService<App> {


    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    Long createApp(AppAddRequest appAddRequest, User loginUser);

    String deployApp(Long appId, User loginUser);

    void generateAppScreenshotAsync(Long appId, String appUrl);

    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);
}
