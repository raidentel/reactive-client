@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  reactive-client startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and REACTIVE_CLIENT_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\reactive-client.jar;%APP_HOME%\lib\charm-5.0.2.jar;%APP_HOME%\lib\rxjavafx-2.2.2.jar;%APP_HOME%\lib\charm-glisten-connect-view-5.0.2.jar;%APP_HOME%\lib\charm-glisten-5.0.2.jar;%APP_HOME%\lib\charm-down-plugin-display-3.8.6.jar;%APP_HOME%\lib\charm-down-plugin-lifecycle-3.8.6.jar;%APP_HOME%\lib\charm-down-plugin-statusbar-3.8.6.jar;%APP_HOME%\lib\charm-cloudlink-client-4.5.2.jar;%APP_HOME%\lib\charm-down-plugin-storage-3.8.6.jar;%APP_HOME%\lib\spring-cloud-starter-feign-1.4.7.RELEASE.jar;%APP_HOME%\lib\spring-cloud-starter-openfeign-1.4.7.RELEASE.jar;%APP_HOME%\lib\spring-cloud-starter-netflix-ribbon-1.4.7.RELEASE.jar;%APP_HOME%\lib\spring-cloud-starter-netflix-archaius-1.4.7.RELEASE.jar;%APP_HOME%\lib\ribbon-2.2.5.jar;%APP_HOME%\lib\ribbon-httpclient-2.2.5.jar;%APP_HOME%\lib\ribbon-transport-2.2.5.jar;%APP_HOME%\lib\ribbon-loadbalancer-2.2.5.jar;%APP_HOME%\lib\ribbon-core-2.2.5.jar;%APP_HOME%\lib\feign-hystrix-9.5.0.jar;%APP_HOME%\lib\hystrix-core-1.4.26.jar;%APP_HOME%\lib\archaius-core-0.7.4.jar;%APP_HOME%\lib\rxnetty-servo-0.4.9.jar;%APP_HOME%\lib\servo-core-0.10.1.jar;%APP_HOME%\lib\servo-internal-0.10.1.jar;%APP_HOME%\lib\guava-29.0-jre.jar;%APP_HOME%\lib\mapstruct-1.3.1.Final.jar;%APP_HOME%\lib\connect-1.5.0.jar;%APP_HOME%\lib\rxjava-2.1.6.jar;%APP_HOME%\lib\charm-down-plugin-device-3.8.0.jar;%APP_HOME%\lib\charm-down-plugin-in-app-billing-3.8.0.jar;%APP_HOME%\lib\charm-down-plugin-push-notifications-3.8.0.jar;%APP_HOME%\lib\charm-down-plugin-runtime-args-3.8.0.jar;%APP_HOME%\lib\charm-down-core-3.8.6.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-2.11.1.jar;%APP_HOME%\lib\error_prone_annotations-2.3.4.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\javax.json-1.0.4.jar;%APP_HOME%\lib\reactive-streams-1.0.1.jar;%APP_HOME%\lib\spring-cloud-starter-1.3.6.RELEASE.jar;%APP_HOME%\lib\spring-cloud-netflix-core-1.4.7.RELEASE.jar;%APP_HOME%\lib\spring-web-4.3.24.RELEASE.jar;%APP_HOME%\lib\spring-cloud-commons-1.3.6.RELEASE.jar;%APP_HOME%\lib\feign-slf4j-9.5.0.jar;%APP_HOME%\lib\feign-core-9.5.0.jar;%APP_HOME%\lib\spring-boot-starter-1.5.21.RELEASE.jar;%APP_HOME%\lib\spring-cloud-context-1.3.6.RELEASE.jar;%APP_HOME%\lib\spring-security-rsa-1.0.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-autoconfigure-1.5.21.RELEASE.jar;%APP_HOME%\lib\spring-boot-1.5.21.RELEASE.jar;%APP_HOME%\lib\spring-context-4.3.24.RELEASE.jar;%APP_HOME%\lib\spring-aop-4.3.24.RELEASE.jar;%APP_HOME%\lib\spring-beans-4.3.24.RELEASE.jar;%APP_HOME%\lib\spring-expression-4.3.24.RELEASE.jar;%APP_HOME%\lib\spring-core-4.3.24.RELEASE.jar;%APP_HOME%\lib\spring-security-crypto-4.2.12.RELEASE.jar;%APP_HOME%\lib\jersey-apache-client4-1.19.1.jar;%APP_HOME%\lib\httpclient-4.5.1.jar;%APP_HOME%\lib\animal-sniffer-annotation-1.0.jar;%APP_HOME%\lib\rxnetty-contexts-0.4.9.jar;%APP_HOME%\lib\rxnetty-0.4.9.jar;%APP_HOME%\lib\spring-boot-starter-logging-1.5.21.RELEASE.jar;%APP_HOME%\lib\logback-classic-1.1.11.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.26.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.26.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.26.jar;%APP_HOME%\lib\netflix-commons-util-0.1.1.jar;%APP_HOME%\lib\netflix-statistics-0.1.1.jar;%APP_HOME%\lib\slf4j-api-1.7.26.jar;%APP_HOME%\lib\rxjava-1.2.0.jar;%APP_HOME%\lib\commons-configuration-1.8.jar;%APP_HOME%\lib\jackson-databind-2.8.11.3.jar;%APP_HOME%\lib\jackson-annotations-2.8.0.jar;%APP_HOME%\lib\jackson-core-2.8.11.jar;%APP_HOME%\lib\snakeyaml-1.17.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.55.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\httpcore-4.4.3.jar;%APP_HOME%\lib\commons-codec-1.9.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\annotations-2.0.0.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\commons-collections-3.2.2.jar;%APP_HOME%\lib\jersey-client-1.19.1.jar;%APP_HOME%\lib\bcprov-jdk15on-1.55.jar;%APP_HOME%\lib\jersey-core-1.19.1.jar;%APP_HOME%\lib\logback-core-1.1.11.jar;%APP_HOME%\lib\jsr311-api-1.1.1.jar

@rem Execute reactive-client
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %REACTIVE_CLIENT_OPTS%  -classpath "%CLASSPATH%" net.fidoteam.reactive.MainApp %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable REACTIVE_CLIENT_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%REACTIVE_CLIENT_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
