
<textarea id="content" name="content" class="form-control" rows="5" data-required data-describedby="message" data-description="content">${view.content}</textarea>

<script type="text/javascript">
function setContent(content) {
	if (content != null && content.length > 0) {
    	if (eshareBlog.browser.ios || eshareBlog.browser.android) {
    		$('#content').text(content);
    	} else {
    		UE.getEditor('content').setContent(content);
    	}
	}
}

$(function () {
	if (!eshareBlog.browser.ios && !eshareBlog.browser.android) {
        seajs.use('editor', function(editor) {
            editor.init(function () {
                $('#content').removeClass('form-control');
			});
        });
    }
})
</script>
