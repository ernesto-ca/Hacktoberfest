function updateOutput() {

	var iframe = document.getElementById('iframe').contentWindow.document;

	iframe.open();
	iframe.write(editor.getValue());
	iframe.close();
}

function editorSetup() {

  window.editor = ace.edit('editor');
  editor.setTheme('ace/theme/monokai');
  editor.getSession().setMode('ace/mode/html');
  editor.setValue(`<!DOCTYPE html>
<html>
<head>
</head>

<body>
</body>

</html>`, 1); //1 = moves cursor to end

  editor.getSession().on('change', function() {
    updateOutput();
  });

  editor.focus();
  
  
  editor.setOptions({
    fontSize: '16pt',
    showLineNumbers: false,
    showGutter: false,
    vScrollBarAlwaysVisible:true,
    enableBasicAutocompletion: false, 
    enableLiveAutocompletion: false
  });

  editor.setShowPrintMargin(false);
  editor.setBehavioursEnabled(false);
}

editorSetup();
updateOutput();