## Usage
 
To run the app run the class SequenceServiceApplication

when the application is up

execute this cUrl

curl --location 'http://localhost:8080/sequence' \
--header 'Content-Type: application/json' \
--data '{
"value1" : "babgbag",
"value2" : "bag"
}'