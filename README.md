# spring-rest-pratice


Key Abstraction Resource



A particular resource has URI

/users/saurabh/todos/1

/users/saurabh/todos

/users/saurabh

A resource can have different representations

XML

JSON

HTML



Example



Create user     POST     /users

Delete user     DELETE /users/1

Get all Users   GET       /users

Get one user   GET      /users/1



Action for resources

Http method

Request uri

Get all users

GET

/users

Create User

POST

/users

Get single user

GET

/users/{id}

e.g./users/1

Delete User

DELETE

/users/{id}

e.g./users/1 

