package com.loop.service.impl;

import com.loop.dao.NotebookDao;
import com.loop.dao.UserDao;
import com.loop.entity.Notebook;
import com.loop.entity.User;
import com.loop.service.NotebookService;
import com.loop.service.exception.NotebookException;
import com.loop.service.exception.UserNotFoundException;
import com.loop.util.NoteUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service("notebookService")
public class NotebookServiceImpl
        implements NotebookService {

    @Resource //注入数据层
    private NotebookDao notebookDao;

    @Resource
    private UserDao userDao;

    public List<Map<String, Object>>
    listNotebooks(String userId)
            throws UserNotFoundException {
        if (userId == null || userId.trim().isEmpty()) {
            throw new UserNotFoundException("ID空");
        }
        User user = userDao.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("ID不存在");
        }
        return notebookDao.findNotebookByUserId(userId);
    }

    @Override
    public Notebook addNotebook(String userId, String name)  {
        if (userId == null || userId.trim().isEmpty()) {
            throw new UserNotFoundException("ID空");
        }
        User user = userDao.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("ID不能存在");
        }
        Notebook notebook = new Notebook(NoteUtil.createId(), name, "book_type_id_1", userId, "", new Timestamp(System.currentTimeMillis()));
        int n = notebookDao.addNotebook(notebook);
        if (n != 1) {
            throw  new NotebookException("创建失败");
        }
        return notebook;
    }
}



