SET JAVA_HOME=C:\Program Files\Java\jdk1.6.0_18
SET PATH=%JAVA_HOME%\bin;%PATH%
SET CLASSPATH=..\..\..\..\..\..\..\build\classes;%CLASSPATH%

xjc src\com\mas\em\common\schema\category_mast.xsd -p com.mas.em.common.vo.category -d src