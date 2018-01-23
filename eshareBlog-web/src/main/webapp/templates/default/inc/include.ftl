<meta property="eshare:eshareBlog" content="2.2.1">
${site_metas}
<script src="${base}/assets/vendors/pace/pace.min.js"></script>
<link href="${base}/assets/vendors/pace/themes/pace-theme-minimal.css" rel="stylesheet" />

<link rel='stylesheet' media='all' href='${base}/assets/vendors/font-awesome/css/font-awesome.min.css'/>
<link rel="stylesheet" media='all' href="${base}/assets/vendors/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" media='all' href="${base}/assets/vendors/animate/animate.min.css">
<link rel='stylesheet' media='all' href='${base}/assets/css/style.css'/>
<link rel='stylesheet' media='all' href='${base}/assets/css/layout.css'/>
<link rel='stylesheet' media='all' href='${base}/assets/css/plugins.css'/>
<link rel='stylesheet' media='all' href='${base}/assets/css/addons.css'/>

<link rel='stylesheet' media='all' href="${base}/assets/vendors/baguette/baguetteBox.min.css"/>

<script type="text/javascript" src="${base}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${base}/assets/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${base}/assets/js/utils.js"></script>

<script type="text/javascript" src="${base}/assets/vendors/layer/layer.js"></script>

<script type="text/javascript" src="${base}/assets/js/sea.js"></script>
<script type="text/javascript" src="${base}/assets/js/sea.config.js"></script>

<!-- Favicons -->
<link rel="apple-touch-icon-precomposed" href="http://eshare.com/dist/images/logo.png"/>
<link rel="shortcut icon" href="http://eshare.com/dist/images/logo.png"/>
<!--Ueditor-->
<script type="text/javascript" src = "${base}/assets/vendors/ueditor/ueditor.parse.js"></script>
<script type="text/javascript">
    var _base_path = '$!{base}';

    window.app = {
        base: '${base}',
        LOGIN_TOKEN: '$!{profile.id}'
    };
	
	window.UEDITOR_HOME_URL = '${base}/assets/vendors/ueditor/';
</script>


<#--禁止复制功能实现-->
<style type="text/css">
    /* 最简单的实现禁止复制的方法，采用css方式禁止文字选择，当然这只兼容webkit内核浏览器 */
    * { -webkit-user-select: none; }
    /*p {font-family: 'Microsoft Yahei';font-size: 28px;}
    input {width: 80%; padding: 10px 20px;}*/
</style>
<#--自定义警告框-->
<script type="text/javascript">
    window.alert = function(str)
    {
        var shield = document.createElement("DIV");
        shield.id = "shield";
        shield.style.position = "absolute";
        shield.style.left = "50%";
        shield.style.top = "50%";
        shield.style.width = "280px";
        shield.style.height = "150px";
        shield.style.marginLeft = "-140px";
        shield.style.marginTop = "-110px";
        shield.style.zIndex = "25";
        var alertFram = document.createElement("DIV");
        alertFram.id="alertFram";
        alertFram.style.position = "absolute";
        alertFram.style.width = "280px";
        alertFram.style.height = "150px";
        alertFram.style.left = "50%";
        alertFram.style.top = "50%";
        alertFram.style.marginLeft = "-140px";
        alertFram.style.marginTop = "-110px";
        alertFram.style.textAlign = "center";
        alertFram.style.lineHeight = "150px";
        alertFram.style.zIndex = "300";
        strHtml = "<ul style=\"list-style:none;margin:0px;padding:0px;width:100%\">\n";
        strHtml += " <li style=\"background:#626262;text-align:left;padding-left:20px;font-size:14px;font-weight:bold;height:25px;line-height:25px;border:1px solid #F9CADE;color:white\">[警告]</li>\n";
        strHtml += " <li style=\"background:#787878;text-align:center;font-size:12px;height:95px;line-height:95px;border-left:1px solid #F9CADE;border-right:1px solid #F9CADE;color:#DCC722\">"+str+"</li>\n";
        strHtml += " <li style=\"background:#626262;text-align:center;font-weight:bold;height:30px;line-height:25px; border:1px solid #F9CADE;\"><input type=\"button\" value=\"确 定\" onclick=\"doOk()\" style=\"width:80px;height:20px;background:#626262;color:white;border:1px solid white;font-size:14px;line-height:20px;outline:none;margin-top: 4px\"/></li>\n";
        strHtml += "</ul>\n";
        alertFram.innerHTML = strHtml;
        document.body.appendChild(alertFram);
        document.body.appendChild(shield);
        this.doOk = function(){
            alertFram.style.display = "none";
            shield.style.display = "none";
        }
        alertFram.focus();
        document.body.onselectstart = function(){return false;};
    }
</script>
<script type="text/javascript">
    // 禁止右键菜单
    document.oncontextmenu = function(){  return false; };
    // 禁止文字选择
    document.onselectstart = function(){    return false;  };
    // 禁止复制
    document.oncopy = function(){    return false;  };
    // 禁止剪切
    document.oncut = function(){    return false;  };
    // 禁止粘贴
    document.onpaste = function(){      return false;  };
</script>
