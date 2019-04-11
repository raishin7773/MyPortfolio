   jQuery(function($) {
     // 削除アイコン押下時
     $('a[name=trashBtn]').click(function() {
       var dataid = $(this).attr("data-id") ;
       $('#deleteTargetId').val(dataid);
     });
     
     $.extend(
        $.fn.dataTable.defaults,
        {
          language: {
            url: "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
          }
        });

     // 編集アイコン押下時
     $('a[name=updateBtn]').click(function() {
       var dataid = $(this).attr("data-id") ;
       var deckName = $(this).attr("data-deckName") ;
       var win = $(this).attr("data-win") ;
       var draw = $(this).attr("data-draw") ;
       var lose = $(this).attr("data-lose") ;
       $('#updateTargetId').val(dataid);
       $('#modalDeckName').val(deckName);
       $('#modalWin').val(win);
       $('#modalDraw').val(draw);
       $('#modalLose').val(lose);
       $('#modalDuels').val(Number(win) + Number(draw) + Number(lose));
     });
     
//     更新モーダルの値変更時
     $('.modalNumber').change(function() {
       var win = $('#modalWin').val();
       var draw = $('#modalDraw').val();
       var lose = $('#modalLose').val();
       $('#modalDuels').val(Number(win) + Number(draw) + Number(lose));
     });
     
     // デッキ一覧テーブル
     $("#decktable").DataTable({
      order: [],
      columnDefs: [
        // 2列目(0から始まるため1になっています)の幅を100pxにする
        { targets: 5, width: 2 },
        { targets: 6, width: 2 },
      ],
     });
     $('#decklist-menu').removeClass('active').addClass('active');
     
   });
