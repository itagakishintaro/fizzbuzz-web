@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\javax\servlet\javax.servlet-api\3.0.1\javax.servlet-api-3.0.1.jar;"%REPO%"\junit\junit\4.10\junit-4.10.jar;"%REPO%"\org\hamcrest\hamcrest-core\1.1\hamcrest-core-1.1.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-core\7.0.34\tomcat-embed-core-7.0.34.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-logging-juli\7.0.34\tomcat-embed-logging-juli-7.0.34.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-jasper\7.0.34\tomcat-embed-jasper-7.0.34.jar;"%REPO%"\org\eclipse\jdt\core\compiler\ecj\3.7.2\ecj-3.7.2.jar;"%REPO%"\org\apache\tomcat\tomcat-jasper\7.0.34\tomcat-jasper-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-servlet-api\7.0.34\tomcat-servlet-api-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-juli\7.0.34\tomcat-juli-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-el-api\7.0.34\tomcat-el-api-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-api\7.0.34\tomcat-api-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-util\7.0.34\tomcat-util-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-jasper-el\7.0.34\tomcat-jasper-el-7.0.34.jar;"%REPO%"\org\apache\tomcat\tomcat-jsp-api\7.0.34\tomcat-jsp-api-7.0.34.jar;"%REPO%"\info\cukes\cucumber-java\1.0.8\cucumber-java-1.0.8.jar;"%REPO%"\info\cukes\cucumber-core\1.0.8\cucumber-core-1.0.8.jar;"%REPO%"\info\cukes\gherkin\2.10.0\gherkin-2.10.0.jar;"%REPO%"\info\cukes\cucumber-html\0.2.1\cucumber-html-0.2.1.jar;"%REPO%"\info\cukes\cucumber-junit\1.0.8\cucumber-junit-1.0.8.jar;"%REPO%"\org\seleniumhq\selenium\selenium-java\2.33.0\selenium-java-2.33.0.jar;"%REPO%"\org\seleniumhq\selenium\selenium-android-driver\2.33.0\selenium-android-driver-2.33.0.jar;"%REPO%"\org\seleniumhq\selenium\selenium-remote-driver\2.33.0\selenium-remote-driver-2.33.0.jar;"%REPO%"\cglib\cglib-nodep\2.1_3\cglib-nodep-2.1_3.jar;"%REPO%"\org\json\json\20080701\json-20080701.jar;"%REPO%"\com\google\guava\guava\14.0\guava-14.0.jar;"%REPO%"\org\seleniumhq\selenium\selenium-chrome-driver\2.33.0\selenium-chrome-driver-2.33.0.jar;"%REPO%"\org\seleniumhq\selenium\selenium-htmlunit-driver\2.33.0\selenium-htmlunit-driver-2.33.0.jar;"%REPO%"\net\sourceforge\htmlunit\htmlunit\2.12\htmlunit-2.12.jar;"%REPO%"\xalan\xalan\2.7.1\xalan-2.7.1.jar;"%REPO%"\xalan\serializer\2.7.1\serializer-2.7.1.jar;"%REPO%"\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar;"%REPO%"\org\apache\commons\commons-lang3\3.1\commons-lang3-3.1.jar;"%REPO%"\org\apache\httpcomponents\httpmime\4.2.3\httpmime-4.2.3.jar;"%REPO%"\commons-codec\commons-codec\1.7\commons-codec-1.7.jar;"%REPO%"\net\sourceforge\htmlunit\htmlunit-core-js\2.12\htmlunit-core-js-2.12.jar;"%REPO%"\xerces\xercesImpl\2.10.0\xercesImpl-2.10.0.jar;"%REPO%"\xml-apis\xml-apis\1.4.01\xml-apis-1.4.01.jar;"%REPO%"\net\sourceforge\nekohtml\nekohtml\1.9.18\nekohtml-1.9.18.jar;"%REPO%"\net\sourceforge\cssparser\cssparser\0.9.9\cssparser-0.9.9.jar;"%REPO%"\org\w3c\css\sac\1.3\sac-1.3.jar;"%REPO%"\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;"%REPO%"\org\eclipse\jetty\jetty-websocket\8.1.9.v20130131\jetty-websocket-8.1.9.v20130131.jar;"%REPO%"\org\eclipse\jetty\jetty-util\8.1.9.v20130131\jetty-util-8.1.9.v20130131.jar;"%REPO%"\org\eclipse\jetty\jetty-io\8.1.9.v20130131\jetty-io-8.1.9.v20130131.jar;"%REPO%"\org\eclipse\jetty\jetty-http\8.1.9.v20130131\jetty-http-8.1.9.v20130131.jar;"%REPO%"\org\apache\httpcomponents\httpclient\4.2.1\httpclient-4.2.1.jar;"%REPO%"\org\apache\httpcomponents\httpcore\4.2.1\httpcore-4.2.1.jar;"%REPO%"\org\seleniumhq\selenium\selenium-firefox-driver\2.33.0\selenium-firefox-driver-2.33.0.jar;"%REPO%"\commons-io\commons-io\2.2\commons-io-2.2.jar;"%REPO%"\org\apache\commons\commons-exec\1.1\commons-exec-1.1.jar;"%REPO%"\org\seleniumhq\selenium\selenium-ie-driver\2.33.0\selenium-ie-driver-2.33.0.jar;"%REPO%"\net\java\dev\jna\jna\3.4.0\jna-3.4.0.jar;"%REPO%"\net\java\dev\jna\platform\3.4.0\platform-3.4.0.jar;"%REPO%"\org\seleniumhq\selenium\selenium-iphone-driver\2.33.0\selenium-iphone-driver-2.33.0.jar;"%REPO%"\org\seleniumhq\selenium\selenium-safari-driver\2.33.0\selenium-safari-driver-2.33.0.jar;"%REPO%"\org\seleniumhq\selenium\selenium-support\2.33.0\selenium-support-2.33.0.jar;"%REPO%"\org\seleniumhq\selenium\selenium-api\2.33.0\selenium-api-2.33.0.jar;"%REPO%"\org\webbitserver\webbit\0.4.14\webbit-0.4.14.jar;"%REPO%"\io\netty\netty\3.5.2.Final\netty-3.5.2.Final.jar;"%REPO%"\fizzbuzz-web\fizzbuzz-web\0.0.1-SNAPSHOT\fizzbuzz-web-0.0.1-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" launch.Main %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
