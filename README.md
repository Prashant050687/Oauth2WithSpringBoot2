# Oauth2WithSpringBoot2
Creating a spring boot 2 microservices application and authenticate using Oauth2.
The application will then be contanerized and deployed on kubernetes cluster using minikube.


# Employee Microservice
It is a simple microservice which acts as a Resource Server. To operations of the employee microservice can only be accessed using a valid oauth token.

# Oauth Server
The oauth server stores the user,role and permissions data and is also responsible for issuing access token and refresh token based on the user credentials and the registered client id and client secrets.

# Oauth Client
The oauth client is a helper microservice to interact with the oauth server so that client secrets dont have to be stored on the client side. 

# Blog
More details can be found on the following blog:
https://prashant-hariharan.blogspot.com/2019/11/architecture-overview.html
