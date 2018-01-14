

before run project, you must have mysql program in your computer to run server application
    

    install mysql program
	
	debian : sudo apt-get install mysql

	archlinux : sudo pacman -S mysql


    launch service mysql (open default port 3306)

	debian : sudo service mysql start

	archlinux : sudo systemctl start mysql




create user and database




to run project


    firstly launch server application

	$ java -jar InterfaceServer.jar


    secondly launch one or many client application

	$ java -jar InterfaceClient.jar

