# POS app #

Retail business need POS system


## Roadmap  ##


* Versi 1.0.0

    * Entry master data
    * Day to day job retail like process transaction
	
	
## Technology, Framework, Tools and Platform ##

Prerequisite for this app

* Java 8
* Maven 3.3.9
* H2 Database
* Spring Boot 2.1.0.RELEASE
* Heroku


## How to start ##

Get the app by git clone or the zip file while the app is under development. 
git clone https://github.com/mujoko/isale.git
or download from https://github.com/mujoko/isale/archive/master.zip

* ensure your cursor is within this folder

        cd isale

* run this command below

        mvn clean spring-boot:run

* browse to [http://localhost:10000/](http://localhost:10000)
* fOR RestFull can test using Swagger [http://localhost:10000/swagger-ui.html](http://localhost:10000/swagger-ui.html)

Development version of this app will be deployed automatically into heroku and this can be access from [https://isale.herokuapp.com](https://isale.herokuapp.com) and Test for REST https://isale.herokuapp.com/swagger-ui.html


## Dockerize the app ##

* Start the container; Name of the container is sbapp
* run this command below in terminal

        docker run -tid -p 10000:10000 --name sbapp springboot-app:latest

* Access the logs in terminal
        docker ps -qa

* Once started, open the REST client, and test the preceding RESTful  using SWAGGER UI
		http://localhost:10000/swagger-ui.html		
		
* and the app can be access trought browser at

		http://localhost:10000/


