package com.suiwan.aicodemother.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.suiwan.aicodemother.model.dto.chathistory.ChatHistoryQueryRequest;
import com.suiwan.aicodemother.model.entity.ChatHistory;
import com.suiwan.aicodemother.model.entity.User;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.util.backoff.BackOff;

import java.time.LocalDateTime;

/**
 *  服务层。
 *
 * @author <a href="https://github.com/WanSuiwan">岁晚</a>
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    boolean deleteByAppId(Long appId);


    /**
     * 分页查询某APP的分页记录
     * @param appId
     * @param pageSize
     * @param lastCreateTime
     * @param loginUser
     * @return
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    /**
     * @param appId
     * @param chatMemory
     * @param maxCount
     * @return
     */
    int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);

    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);
}
