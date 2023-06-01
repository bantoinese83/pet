aws dynamodb list-tables --endpoint-url http://localhost:8000
docker start f194dd46a079
aws dynamodb list-tables --endpoint-url http://localhost:8000   
doepesci@DOEs-MBP pet % aws dynamodb delete-table --table-name User --endpoint-url http://localhost:8000
aws dynamodb scan --table-name User --endpoint-url http://localhost:8000
docker ps



aws dynamodb create-table \
--table-name Pet \
--attribute-definitions \
AttributeName=id,AttributeType=S \
--key-schema AttributeName=id,KeyType=HASH \
--provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
--endpoint-url http://localhost:8000


aws dynamodb create-table \
--table-name User \
--attribute-definitions \
AttributeName=email,AttributeType=S \
--key-schema AttributeName=email,KeyType=HASH \
--provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
--endpoint-url http://localhost:8000


aws dynamodb create-table \
--table-name Interactions \
--attribute-definitions \
AttributeName=id,AttributeType=S \
--key-schema AttributeName=id,KeyType=HASH \
--provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
--endpoint-url http://localhost:8000


chat gpt api key

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