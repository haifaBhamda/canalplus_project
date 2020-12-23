# creation du spring boot Rest api avec H2 database
#### ci-dessous la structure de projet 


#### configure H2database




#### insertion des donnée dans la base de donnéé avec le fichier dataql

### Development Steps : 


<b>step 1</b>: creation des models 
<b>step 2</b>: creation des repositories
<b>step 3</b>: creation des services et ces interfaces
<b>step 3</b>: creation des controllers

### Tester l'api avec postman : 
*<b>Créer un nouvel abonnér</b>: [http://localhost:8080/api/createSubscriber] 
*<b>Souscrire à un contrat </b>: [http://localhost:8080/api/subscribers/{subscriberId}/createcontract]
*<b>Modifier l’adresse d'un abonné </b>: [http://localhost:8080/api/subscribers/{subscriberId}] 
*<b>Récupérer les informations sur les contrats d’un abonné</b>: [http://localhost:8080/api/subscribers/{subscriberId}/getAllContracts]
*<b>Récupérer l’historique des mouvements de modification effectués pour unabonné</b>: [http://localhost:8080/history/{subscriberId}/getHistory] 



