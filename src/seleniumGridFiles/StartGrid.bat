

start java -jar selenium-server-standalone-2.48.2.jar -role hub   

start java -jar selenium-server-standalone-2.48.2.jar -role webdriver -hub http://localhost:4444/grid/register -browser browserName="internet explorer",version=ANY,platform=WINDOWS,maxInstances=2 -Dwebdriver.ie.driver="%CD%\IEDriver\IEDriverServer.exe"

start java -jar selenium-server-standalone-2.48.2.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -browser browserName=firefox,maxInstances=2






