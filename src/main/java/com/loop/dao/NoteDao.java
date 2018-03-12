package com.loop.dao;


import com.loop.entity.Note;

import java.util.List;
import java.util.Map;

public interface NoteDao {

    /**
     * 查询一个笔记本中的全部笔记信息
     *
     * @param notebookId
     * @return 笔记列表, 每个元素包含id和titile
     */
    List<Map<String, Object>> findNotesByNotebookId(
            String notebookId);

    Note findNoteById(String noteId);

    int updateNote(Note note);

    int addNote(Note note);

    int removeNote(Note note);

}



