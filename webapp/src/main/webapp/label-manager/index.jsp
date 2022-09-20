<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="labelTable" class="org.beanmaker.labels.LabelMasterTableView"/>
<html>
<head>
    <title>LABELS</title>
    <link rel="stylesheet" href="main.css">
</head>
<body class="bg-stone-400">
<h1>Beanmaker Label Manager</h1>

${labelTable.summaryInfo}
${labelTable.masterTable}

</body>
</html>
