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
    p {font-family: 'Microsoft Yahei';font-size: 28px;}
    input {width: 80%; padding: 10px 20px;}
</style>
<#--<h1>本代码在UC手机浏览器上不生效，其它手机浏览器暂未发现问题、PC全部没问题。</h1>
<p>这是一段示例文字，我无法被选中，也无法按下鼠标右键，即使被选中你也无法复制！</p>
<input type="text" value="文本框中的文字可以选中，但是无法复制粘贴"/>-->
<script type="text/javascript">
    // 禁止右键菜单
    document.oncontextmenu = function(){ return false; };
    // 禁止文字选择
    document.onselectstart = function(){ return false; };
    // 禁止复制
    document.oncopy = function(){ return false; };
    // 禁止剪切
    document.oncut = function(){ return false; };
    // 禁止粘贴
    document.onpaste = function(){ return false; };
</script>