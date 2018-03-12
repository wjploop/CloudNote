package com.loop.dao;


import com.loop.entity.Notebook;

import java.util.List;
import java.util.Map;

public interface NotebookDao {
	
	/**
	 * 根据用户的ID查找这个用户的全部笔记本信息 
	 * @param userId 用户ID
	 * @return 笔记本信息列表, 每个笔记本信息包含id和name属性
	 */
	List<Map<String, Object>> findNotebookByUserId(
            String userId);
	
	Notebook findNotebookById(String notebookId);

	int addNotebook(Notebook notebook);

	
}




