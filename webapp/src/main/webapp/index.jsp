<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beanmaker Label Manager</title>
</head>
<body>
<h1>Beanmaker Label Manager</h1>
<p>
    This the Beanmaker Label Manager test web-app.
</p>
<p>
    To deploy it on your platform, the label-manager-lib-{version}.jar must be on your classpath and the directory
    /label-manager should be copied to some appropriate  place. The directory can be renamed.
</p>
<p>
    You also need to include and (very probably) edit the servlet definitions present in the web.xml file into your
    own application web.xml. You should not change the last part of the path in servlet mappings.
</p>
<p>
    In the /label-manager directory you need to edit the config.js file to match the servlet mappings in your
    web.xml file.
</p>
<p>
    Finally, when you initialize your application, you should use the Configuration class to set up the proper
    settings for table and field names.
</p>
</body>
</html>
