package com.yjx.aiautocode.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.yjx.aiautocode.model.dto.app.AppQueryRequest;
import com.yjx.aiautocode.model.entity.App;
import com.yjx.aiautocode.model.vo.AppVO;

import java.util.List;


/**
 * 应用 服务层。
 *
 * @author YJX
 */
public interface AppService extends IService<App> {


    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);
}
