package com.loop.service;

import com.loop.entity.Note;
import com.loop.service.exception.NoteNotFoundException;
import com.loop.service.exception.NotebookNotFoundException;
import com.loop.service.exception.UserNotFoundException;

import java.util.List;
import java.util.Map;

public interface NoteService {
	/**
	 * 笔记列表功能 
	 * @param notebookId 笔记本ID
	 * @return 笔记本中的笔记列表, 每个笔记对象包含
	 *   id和title两个属性 
	 * @throws NotebookNotFoundException 笔记本不存在
	 *   时候抛出异常 
	 */
	List<Map<String, Object>> listNotes(
            String notebookId)
		throws NotebookNotFoundException;

	Note getNote(String noteId)
			throws NoteNotFoundException;

	boolean update(String noteId,
                   String title, String body)
		throws NoteNotFoundException;

	Note addNote(String userId,
                        String notebookId, String title)
			throws UserNotFoundException,
			NotebookNotFoundException;

	boolean moveNote(String noteId, String notebookId);

	boolean removeNote(String noteId);
}



