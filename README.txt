

before run project, you must have mysql program in your computer to run server application or use remote database
    

    install mysql program
	
	debian : sudo apt-get install mysql

	archlinux : sudo pacman -S mysql


    launch service mysql (open default port 3306)

	debian : sudo service mysql start

	archlinux : sudo systemctl start mysql




create user and database


    user root passwd root

	$ mysql_secure_installation
	    add user root
	    passwd root
	

    create database universityRequest

	$ mysql -p -u root

	> create database universityRequest;




to run project


    firstly launch server application

	$ java -jar InterfaceServer.jar


    secondly launch one or many client application

	$ java -jar InterfaceClient.jar


clic to "connect", in the menu "server" clic "connect".

Done ! Your server is online.
