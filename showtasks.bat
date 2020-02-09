call C:\Users\anaka\Downloads\tasks\runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo runcrud has errors. - breaking work
goto fail

:runbrowser
start chrome
start chrome http://localhost:8080/crud/v1/task/getTasks
goto end


:fail
echo.
echo There were errors.

:end
echo.
echo Work is finished.