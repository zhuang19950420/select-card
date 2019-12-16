function getModuleInfo() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/getStatu",
        success: function (json) {
            var typeData = json.data;

            $.each(typeData, function (i, n) {
                var tbBody = "";
                var typeResult;
                if (n.type === 'true') {
                    typeResult = "正常";
                } else {
                    typeResult = "异常"
                }
                tbBody += "<tr><td>"  + n.url + "</td>"+ "<td>"+ n.url + "</td>" + "<td>" + typeResult + "</td></tr>";
                $("#tbody-result").append(tbBody);
            });
        },
        error: function (json) {
            alert("加载失败");
        }
    });
}