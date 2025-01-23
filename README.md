# Prova Finale di Ingegneria del Software - AA 2021-2022

![alt text](src/main/resources/Graphical_Assets/Eriantys_slider.jpg)

Implementation of the board game [Eriantys](https://www.craniocreations.it/prodotto/eriantys/), a strategic board game created by Cranio Creations, where players compete to gain control over magical islands by deploying students, using professors' abilities, and leveraging unique character cards. The game features various elements such as magical creatures, islands to conquer, and special powers to outmaneuver opponents.This digital version introduces a multiplayer online feature supporting up to three players, incorporates game-saving capabilities, and ensures resilience, allowing players to disconnect and reconnect without disrupting the game's continuity. Developed as part of a bachelor's thesis, this adaptation encompasses a detailed implementation that spans a graphical user interface (GUI), a command-line interface (CLI), and network functionalities via sockets, providing an immersive digital experience of Eriantys.

Professor: Alessandro Margara

Grade: 30/30 cum laude

## Documentation

### UML

- [UML Iniziale](deliveries/UML/UML_Iniziale/UML_Iniziale.jpg)
- [UML FInale](deliveries/UML/UML_Final/FinalUML.png)

## Funzionanlità implementate

| Functionality   |                       State                        |
|:----------------|:--------------------------------------------------:|
| Basic rules     | 🟢 |
| Complete rules  | 🟢 |
| Character Cards | 🟢 |
| Socket          | 🟢 |
| GUI             | 🟢 |
| CLI             | 🟢 |
| Persistence     | 🟢 |

### Jars
After the download you can start the game with jars. To use the jars you must compile with maven , then the executable will be found under the directory target
## JAR execution
After the jar are compiled there are two different kinds of executable for the client side.

CLI

To run the game with CLI you must run AM29-clientCLI.jar

GUI

To run the game with Gui you must run the AM29-clientGUI.jar

Server

To run the server you must run AM29-server.jar
### Test

## Overall Coverage Summary

| Package     | Class % | Line % |
|:------------|:--------|:------:|
| all classes | 46%     |  20%   |
| model       | 100%    |  82%   |

## Group components
- [_Roberto Cialini_](https://github.com/RobertoCialini)
- [_Umberto Colangelo_](https://github.com/umbertocolangelo)
- [_Vittorio La Ferla_](https://github.com/vittoriolaferla)
