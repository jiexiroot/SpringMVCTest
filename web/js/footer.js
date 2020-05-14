/** Created by GOU on 2020-05-14 17:01  */

$(function(){
    function footerPosition(){
        $(".footer").removeClass("fixed-bottom");
        //网页正文全文高度
        var contentHeight = document.body.scrollHeight,
        //可视窗口高度，不包括浏览器顶部工具栏
            winHeight = window.innerHeight;
        if(!(contentHeight > winHeight)){
        //当网页正文高度小于可视窗口高度时，为footer添加类fixed-bottom
            $(".footer").addClass("fixed-bottom");

        } else {
            $(".footer").removeClass("fixed-bottom");

        }
    }
    footerPosition();
    $(window).resize(footerPosition);
});
