	echo "Welcome to batch Execution"
	cd D:\AravindData\Synechron_BDD\12_09_2020\Eclipse_WS\actitime
	d:
	set classpath=D:\AravindData\Synechron_BDD\12_09_2020\Eclipse_WS\actitime\target\*;.
	mvn -DTest=TestRunner test
	pause