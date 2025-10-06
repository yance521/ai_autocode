package com.yupi.yuaicodemother.genresult.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.yupi.yuaicodemother.genresult.entity.ChatHistory;
import com.yupi.yuaicodemother.genresult.mapper.ChatHistoryMapper;
import com.yupi.yuaicodemother.genresult.service.ChatHistoryService;
import org.springframework.stereotype.Service;

/**
 * 对话历史 服务层实现。
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 */
@Service
public class ChatHistoryServiceImpl extends ServiceImpl<ChatHistoryMapper, ChatHistory>  implements ChatHistoryService{

}
