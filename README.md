# Project structure
### COLLECTOR 
Collector service collects data by REST protocol and transfer all to kafka queue.

### PROCESSOR
Processor continuously listens kafka queue and process incoming messages.
After success data processing calculated score stored in Redis    


# Starting up
Before execution any of services, it is needed to execute docker-compose file

Execute from project root directory:

**docker-compose up -d**

After a dozen of second check that all services are up,
kafka and redis services should be in status UP

**docker ps**

After starting up docker images project can be build and started from same directory by follow command

**./gradlew --parallel clean build collector:bootRun processor:bootRun**