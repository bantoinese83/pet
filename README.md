README.md

# Virtual Pet Adoption Platform

Welcome to the Virtual Pet Adoption Platform. This is a Spring Boot application that allows users to adopt and take care of virtual pets.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

Java 11 or higher
Maven
Spring Boot
AWS CLI (configured with your AWS credentials)


### Installing

A step by step series of examples that tell you how to get a development environment running:

1. Clone the repository to your local machine.
2. Navigate to the project directory and run `mvn clean install`.
3. Run the application using `mvn spring-boot:run`.

## Running the tests

Explain how to run the automated tests for this system:

1. Navigate to the project directory.
2. Run `mvn test`.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [AWS Lambda](https://aws.amazon.com/lambda/)
* [Amazon DynamoDB](https://aws.amazon.com/dynamodb/)

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Your Name** - *Initial work* - [YourGitHub](https://github.com/yourgithub)

See also the list of [contributors](https://github.com/yourgithub/virtual-pet-adoption-platform/contributors) who participated in this project.


aws dynamodb scan --table-name User --endpoint-url http://localhost:8000
docker ps

doepesci@DOEs-MBP pet % aws dynamodb delete-table --table-name User --endpoint-url http://localhost:8000

aws dynamodb create-table \
--table-name User \
--attribute-definitions AttributeName=email,AttributeType=S \
--key-schema AttributeName=email,KeyType=HASH \
--provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
--endpoint-url http://localhost:8000


aws cloudformation update-stack --stack-name virtualPet --template-body file:///Users/doepesci/Downloads/pet/src/main/resources/virtualPet.yaml

aws dynamodb list-tables --endpoint-url http://localhost:8000   

docker start f194dd46a079 

docker run -p 8000:8000 amazon/dynamodb-local -jar DynamoDBLocal.jar -inMemory -sharedDb 