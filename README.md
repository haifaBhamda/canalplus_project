# creation du spring boot project avec H2 database
# architecture microservice et injection de dependence
### Development Steps : 
<b>step 1</b>: creation des models 
   * Subscriber.java   
   * Contractor.java
   * History.java
   * Address.java
   * ModificationType.java

<b>step 2</b>: creation des repositories
   * SubscriberRepository
   * ContractorRepository
   * HistoryRepository
<b>step 3</b>:creation des services et ces interfaces
   * SubscriberService/SubscriberServiceImpl
   * ContractorService/ContractorServiceImpl
   * HistoryService/HistoryServiceImpl
<b>step 4</b>:creation des controllers
   * SubscriberCntroller
   * ContractorController
   * HistoryController

### Tester les api  : 
<b>Créer un nouvel abonnér</b>:<http://localhost:8080/api/createSubscriber>

<b>Souscrire à un contrat </b>:<http://localhost:8080/api/subscribers/{subscriberId}/createcontract>

<b>Modifier l’adresse d'un abonné</b>:<http://localhost:8080/api/subscribers/{subscriberId}> 

<b>Récupérer les informations sur les contrats d’un abonné</b>:<http://localhost:8080/api/subscribers/{subscriberId}/getAllContracts>

<b>Récupérer l’historique des mouvements de modification effectués pour unabonné</b>:<http://localhost:8080/history/{subscriberId}/getHistory> 



