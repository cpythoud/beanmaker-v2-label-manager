<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="htmlWrapper" class="org.beanmaker.labels.HtmlWrapper"/>
<jsp:useBean id="labelTable" class="org.beanmaker.labels.LabelMasterTableView"/>
<!DOCTYPE html>
<html>
<head>
    <title>LABELS</title>
    <link rel="stylesheet" href="main.css">
</head>
<body class="bg-stone-300">

<div class="container mx-auto py-12 px-6">
    <h1 class="text-4xl font-bold pb-8">Beanmaker Label Manager</h1>

    <div class="w-full">
        <div id="error_messages_0"></div>
        <form id="Label_0" name="Label" method="post" class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
            <p class="mb-4">
                <label for="name" class="block text-gray-700 text-sm font-bold mb-2">Code</label>
                <input type="text" name="name" id="name" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
            </p>
            <c:forEach var="lang" items="${htmlWrapper.languages}">
                <p class="mb-4">
                    <label for="${lang.iso}" class="block text-gray-700 text-sm font-bold mb-2">${lang.getCapIso()}</label>
                    <input type="text" name="${lang.iso}" id="${lang.iso}" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                </p>
            </c:forEach>
            <p>
                <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold text-2xl py-2 px-8 rounded focus:outline-none focus:shadow-outline" type="submit">
                    +
                </button>
            </p>
        </form>
    </div>

    ${labelTable.summaryInfo}
    ${labelTable.masterTable}
</div>

<script src="cctable2.js"></script>
<script src="beanmaker2.js"></script>
<script src="main.js"></script>

</body>
</html>
