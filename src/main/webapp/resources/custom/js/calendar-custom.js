    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

$(document).ready(function(){


    getBookListAndDraw();
    $('#use-dt-tm').datepicker({
        dateFormat: 'yy-mm-dd'
    });


});

function addBook(){
    var addBookForm = $("#addBookForm").serialize();

    var bokPrsNm = $("#book-prs-name").val()
    if (bokPrsNm==""){
        alert("No Name!");
        return;
    }

    var useDtTm = $("#use-dt-tm").val()
        if (useDtTm==""){
            alert("No Date!");
            return;
        }

    var useStTm = $("#use-st-tm").val()
        if (useStTm==""){
            alert("No Start Time!");
            return;
        }

    var useEndTm = $("#use-end-tm").val()
            if (useEndTm==""){
                alert("No End Time!");
                return;
            }

    $.ajax({
        type: 'POST',
        url: '/main/book',
        dataType: 'text',
        data: addBookForm,
        success: function(resultMsg){
            alert(resultMsg);
            location.reload();
        },
        error: function(){
            alert('AJAX ERROR')
        }
    });
}

function dateParser(date, time){
    var separateDate = date.split('-');
    var separateTime = time.split(':');

    var year = parseInt(separateDate[0]);
    var month = parseInt(separateDate[1]) - 1;
    var day = parseInt(separateDate[2]);
    var hour = parseInt(separateTime[0]);
    var minute = parseInt(separateTime[1]);

    return new Date(year, month, day, hour, minute);
}

function getBookListAndDraw(){
    $.ajax({
        type: 'GET',
        url: '/main/book',
        dataType: 'json',
        success: function(data){
            var parsedBookList = bookParser(data);

            $('#calendar').fullCalendar({
                    header: {
                        left: 'title',
                        center: 'month,agendaWeek,agendaDay',
                        right: 'prev,today,next'
                    },
                    editable: false,
                    droppable: false,
                    select: function (start, end, allDay) {
                        var title = prompt('Event Title:');
                        if (title) {
                            calendar.fullCalendar('renderEvent', {
                                    title: title,
                                    start: start,
                                    end: end,
                                    allDay: allDay
                                }, true // make the event "stick"
                            );
                        }
                        calendar.fullCalendar('unselect');
                    },
                    events: parsedBookList,
                    eventRender: function (event, element, icon) {
                        if (!event.description == "") {
//                            element.find('.fc-title').append("<br/><span class='ultra-light'>" + event.description +
                            element.find('.fc-title').append("  <span class='ultra-light'>" + event.description +
                                "</span>");
                        }
                        if (!event.icon == "") {
                            element.find('.fc-title').append("<i class='air air-top-right fa " + event.icon +
                                " '></i>");
                        }
                    },

                    windowResize: function (event, ui) {
                        $('#calendar').fullCalendar('render');
                    }
                });
            $('#calendar').fullCalendar('changeView', 'agendaWeek');
        },
        error: function(data){
            alert('getBookListAndDraw() AJAX ERROR')
        }
    })
}

function bookParser(bookList){
    var parsingArr = new Array();

    for(var i=0; i < bookList.length; i++){
        var book = bookList[i];
        var obj = new Object();
        obj.id = book._id.$oid;
        obj.title = book.bokPrsNm;
        obj.description = book.bokMemo;
        obj.start = dateParser(book.useDtTm, book.useStTm);
        obj.end = dateParser(book.useDtTm, book.useEndTm);
        obj.className = ['event', 'bg-color-blue'];
        obj.icon = 'fa-clock-o';
        parsingArr.push(obj);
    }
    return parsingArr;
}