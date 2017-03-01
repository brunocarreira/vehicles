Vehicles Exercise
===================


Application that reads a **JSON** string from a URL, parse it into vehicle list, and produces output based on some criterias:
> - **Print a list of all the cars, in ascending price order, in the following format:**
1. {Vehicle name} – {Price}
> - **Using a reference table, calculate the specification of the vehicles based on their SIPP. Print the specification out using the following format:**
1. {Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con}
> - **Print out the highest rated supplier per car type, descending order, in the following format:**
1. {Vehicle name} – {Car type} – {Supplier} – {Rating}
> - **Give each vehicle a score based on the below breakdown, then combine this score with the suppliers rating. Print out a list of vehicles, ordered by the sum of the scores in descending order, in the following format:**
1. {Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}

#### <i class="icon-refresh"></i> Main classes

This Application is divided in 2 parts:

**Part1** - A standalone Java console application, with the functionality to read a specified JSON file, parse and then perform the set tasks above on the parsed data. All tasks should be printed out to the console using System.out.
> *Represented by* **com.brunocarreira.vehicles.Part1App.java**

**Part2** - Using the code created in Part 1 extend the code to provide the output through a REST API.
> *Represented by* **com.brunocarreira.vehicles.Part2App.java**

----------


Instructions
-------------

**Prerequisites** 

> - Maven 3
> - JDK 1.8
> - IDE

Go to vehicles path and install the application jar and its dependencies in your local maven repository (Unit Tests and Integrations Tests will be executed):

> **mvn clean install**

**Executing Part1** 

> **Eclipse**: Right click on Part1App.java > Run as > Java Application

> **Command line**: mvn exec:exec -Ppart1


**Executing Part2** 

> mvn clean spring-boot:run


> http://localhost:8080/vehicles/priceOrder
 
> http://localhost:8080/vehicles/priceOrderJSON

> http://localhost:8080/vehicles/sipp

> http://localhost:8080/vehicles/sippJSON

> http://localhost:8080/vehicles/highSupplier

> http://localhost:8080/vehicles/highSupplierJSON

> http://localhost:8080/vehicles/score

> http://localhost:8080/vehicles/scoreJSON


> **Shutdown Spring Boot**: http://localhost:8080/shutdown


> **Hint:**

> - To enable logs, comment the lines below, in application.properties:

> **logging.level.root=OFF**

> **spring.main.banner-mode=off**


----------


Project Structure
-------------------

Spring-boot was used to setup the project and organize into layers.

> **```package com.brunocarreira.vehicles.services```**
> - Contains the services components:
> > **```VehicleService```** - Implements the most important Business logic of the App.
> > **```JsonDSService```** - JSON DataSource Service


> **```package com.brunocarreira.vehicles.domain```**
> - Domain Model (Entities if using JPA):
> > **```Search```** - Container class for Vehicles.
> > **```Vehicle```** - POJO Object to store Vehicle


> **```package com.brunocarreira.vehicles.dto```**
> - POJOs used only for JSON REST responses (better bandwidth use):
> > **```VehicleHighSupplierDTO```**
> > **```VehiclePriceDTO```**
> > **```VehicleScoreDTO```**
> > **```VehicleSIPPDTO```**

> **```package com.brunocarreira.vehicles.resource```**
> - Resource for REST endpoints:
> > **```VehicleResource```**


----------


Tests
-------------------

Spring-boot was also used to create Unit/Integration tests, using Mocks.

**MockedVehicleServiceTest** 
> Services and data were mocked to test the main functionality. The tests are simple and should be improved.

**DataSourceTest** 
> Check DataSource with the wrong URL.

**VehicleResourceTest** 
> Integration Test: Check REST Controllers response type and status.

**VehicleServiceTest** 
> Unit Test: Checking return of main functionality.
