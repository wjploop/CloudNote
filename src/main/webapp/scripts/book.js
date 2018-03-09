function loadBooksByUserId() {
    //获取userId
    var userId = getCookie("userId");
    if (userId == null) {
        window.location.href("login.html");
    } else {
        $.ajax({
            url: path + "/book/load.do",
            type: "post",
            data: {"userId": userId},
            dataType: "json",
            success: function (result) {
                if (result.state === 0) {
                    //处理笔记本数据集合
                    var books = result.data;
                    for (var i = 0; i < books.length; i++) {
                        var bookId = books[i].id;
                        var bookName = books[i].name;
                        //创建一个笔记本Li的元素
                        createBookLiElement(bookId, bookName);
                    }
                }
            },
            error: function () {

            }

        });
    }
}


function createBookLiElement(bookId, bookName) {
    var sli = "";
    sli += '<li class="online">' +
        '<a>' +
        '<i class="fa fa-book" title="online" rel="tooltip-bottom"></i> ' +
        bookName +
        '</a></li>';

    //将sli字符串转换成jQuery对象元素li元素
    var $li = $(sli);

    //讲bookId值与jQuery对象绑定
    $li.data("bookId", bookId);

    //将li元素添加到ul列表中
    $("#book_ul").append($li);


}


function loadNotesByBookId() {
    var bookId = $(this).data("bookId");


    //设置选中效果
    $("#book_ul a").removeClass("checked");
    $(this).find("a").addClass("checked");

    // alert(bookId);

    $.ajax({
        url: path + "/note/load_notes.do",
        type: "post",
        data: {"bookId": bookId},
        dataType: "json",
        success: function (result) {
            if (result.state === 0) {
                var notes = result.data;

                //清空原数据
                $("#note-ul").empty();

                for (var i = 0; i < notes.length; i++) {
                    var noteTitle = notes[i].title;
                    var noteId = notes[i].id;
                    createNoteLiElement(noteTitle,noteId);
                }
            } else {
                $("#note-ul").empty();
                alert("该笔记本没有笔记");
            }
        },
        error: function () {
            alert("ajax请求失败");
        }
    });

}

function loadNoteById() {

    //设置选中效果
    $("#note-ul a").removeClass("checked");
    $(this).find("a").addClass("checked");

    //获取请求参数
    var noteId = $(this).data("noteId");

    //ajax请求
    $.ajax({
        url: path + "/note/load_note.do",
        type:"post",
        data:{"noteId":noteId},
        dataType:"json",
        success:function(result) {
            if(result.state===0) {
                var note=result.data;

                var title=note.title;
                var content=note.content;

                $("#input_note_title").val(title);
                um.setContent(content);
            }
        },
        error:function () {

        }


    });



}

function createNoteLiElement(noteTitle,noteId) {
    var strLi = "";
    strLi+='<li class="online">' +
        '<a>' +
        '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom">'+noteTitle+'</i> ' +
        '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down">' +
        '<i class="fa fa-chevron-down"></i> ' +
        '</button> ' +
        '</a>' +
        '</li>'

    // strLi += '<li class="online">' +
    //     '                                <a>' +
    //     '                                    <i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>' + "  " + noteTitle +
    //     '                                    <button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>' +
    //     '                                </a>' +
    //     '                                <div class="note_menu" tabindex=\'-1\'>\n' +
    //     '                                    <dl>\n' +
    //     '                                        <dt>\n' +
    //     '                                            <button type="button" class="btn btn-default btn-xs btn_move"\n' +
    //     '                                                    title=\'移动至...\'><i class="fa fa-random"></i></button>\n' +
    //     '                                        </dt>\n' +
    //     '                                        <dt>\n' +
    //     '                                            <button type="button" class="btn btn-default btn-xs btn_share" title=\'分享\'><i' +
    //     '                                                    class="fa fa-sitemap"></i></button>\n' +
    //     '                                        </dt>\n' +
    //     '                                        <dt>\n' +
    //     '                                            <button type="button" class="btn btn-default btn-xs btn_delete" title=\'删除\'>\n' +
    //     '                                                <i class="fa fa-times"></i></button>\n' +
    //     '                                        </dt>\n' +
    //     '                                    </dl>\n' +
    //     '                                </div>\n' +
    //     '                            </li>'

    var $li = $(strLi);


    $li.data("noteId",noteId);

    $("#note-ul").append($li);
}
