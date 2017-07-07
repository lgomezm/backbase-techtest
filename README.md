# Backbase tech test

## Setup Instructions

This project needs Java8 and maven in order to build.

* To build, just run
    `mvn clean package`.
    
* To run you need to install an application container like Tomcat, so it can be deployed.


## Health Check

To check it works, in your browser go to `http://localhost:8080/techtest/transactions`. You can authenticate with `backbase/123456`.

Other urls: 

* `GET /techtest/transactions/{transaction_type}` returns transactions by transaction type.  
* `GET /techtest/transactions/{transaction_type}/amount` returns the total amount for transactions of type `{transaction_type}`.
