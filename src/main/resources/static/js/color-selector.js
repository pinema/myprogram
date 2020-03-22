$(function() {
    // 布局保存
    $("#component-sav").click(function () {
        //组件 数组
        let elementIdList = [];
        $.ajax({
                type: "POST",
                url: "/dataListSave",
                data: {elementIdList: JSON.stringify(elementIdList)},
                // dataType: "json",
                // contentType: false,
                success: function(data){
                    console.log(data);
                },
                error: function(){
                    console.error("error");
                }
        });

    });

});

// 颜色选择器
layui.use('colorpicker', function(){
    var $ = layui.$
    ,colorpicker = layui.colorpicker;
    //初始色值
    colorpicker.render({
        elem: '#color_select'
        ,size: 'lg' //大号下拉框
        ,color: '#2ec770' //设置默认色
        ,done: function(color){
            layer.tips('选择了：'+ color, this.elem);
        }
    });
});
$("#color_select").click(function(){
    // console.log("asd");
    document.getElementById("layui-colorpicker1").classList.add("layui-box");
});
