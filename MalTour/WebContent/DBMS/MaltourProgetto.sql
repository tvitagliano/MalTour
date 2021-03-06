-- username: root
-- password: Password7
DROP DATABASE `maltour`;
CREATE DATABASE IF NOT EXISTS `maltour`;
USE `maltour`;

CREATE TABLE `utente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `passwordhash` char(40) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gestore` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`username`),
  UNIQUE KEY (`email`)
);

CREATE TABLE `servizio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descrizione` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `offerta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `destinazione` varchar(45) NOT NULL,
  `descrizione` longtext NOT NULL,
  `data_partenza` varchar(45) NOT NULL,
  `ora_partenza` varchar(45) NOT NULL,
  `data_ritorno`varchar(45) NOT NULL,
  `ora_ritorno` varchar(45) NOT NULL,
   `partenza_da` varchar(45) NOT NULL,
    `arrivo_a` varchar(45) NOT NULL,
	`pernottamento` varchar(45) ,
	`posti_disponibili`int NOT NULL,
  `prezzoCent` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  FULLTEXT KEY (`destinazione`),
  FULLTEXT KEY (`destinazione`,`descrizione`)
);

CREATE TABLE `ordine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `stato` boolean NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `componentiViaggio` (
  `idordine` int(11) NOT NULL ,
  `nome` varchar(45) NOT NULL,
   `cognome` varchar(45) NOT NULL,
  `data_nascita` varchar(45) NOT NULL,
  PRIMARY KEY (`idordine`),
  CONSTRAINT FOREIGN KEY (`idordine`) REFERENCES `ordine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE `pagamento` (
  `idutente` int(11) NOT NULL,
  `numero_carta` bigint(32) NOT NULL,
   `titolare_carta` varchar(45) NOT NULL,
  `cvv` int(3) NOT NULL,
   `data_scadenza` varchar(45) NOT NULL,
  PRIMARY KEY (`idutente`),
  CONSTRAINT FOREIGN KEY (`idutente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `ordine_offerta` (
  `idofferta` int(11) NOT NULL,
  `idordine` int(11) NOT NULL,
  PRIMARY KEY (`idordine`,`idofferta`),
  CONSTRAINT FOREIGN KEY (`idofferta`) REFERENCES `offerta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FOREIGN KEY (`idordine`) REFERENCES `ordine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `offerta_servizio` (
  `idofferta` int(11) NOT NULL,
  `idservizio` int(11) NOT NULL,
  PRIMARY KEY (`idofferta`,`idservizio`),
  CONSTRAINT FOREIGN KEY (`idofferta`) REFERENCES `offerta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FOREIGN KEY (`idservizio`) REFERENCES `servizio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);
UNLOCK TABLES;
LOCK TABLES `utente` WRITE;
INSERT INTO `utente` VALUES
 (1,'Angela',SHA1('titolare01'),'TITOLARE','angela@maltour.com',0),
 (2,'Teresa',SHA1('dipendente02'),'DIPENDENTE01','teresa@maltour.com',1),
 (3,'Lucia',SHA1('dipendente03'),'DIPENDENTE02','lucia@maltour.com',2);
UNLOCK TABLES;


LOCK TABLES `servizio` WRITE;
INSERT INTO `servizio` VALUES 
(1,'TOUR','tour enogastronomici e culturali, alla scoperta dell italia'),
(2,'CITTA EUROPEE','Citt?? grandi e piccole, ricche di storia e cultura, sede di grandi eventi e nuove aperture, paesaggi pittoreschi e luoghi incantati a due passi dall???Italia: date un???occhiata alle 19 Citt?? Europee da vedere nel 2019 e regalatevi un viaggio bellissimo, che possa restarvi nella mente, nel cuore e nella memoria???'),
(3,'DESTINAZIONE MARE','Ci sono tantissimi luoghi che vi attendono, qui abbiamo realizzato una piccola guida con qualche destinazione che pu?? tornarvi utile la prossima estate.'),
(4,'MINICROCIERE','Hai solo qualche giorno libero e stai pensando ad una vacanza in alto mare? Di seguito ti proponiamo un elenco di mini crociere. Si tratta di Crociere che durano meno di 7 giorni, ma avrai la sensazione di viverne molti di pi??.');
UNLOCK TABLES;


LOCK TABLES `offerta` WRITE;
INSERT INTO `offerta` VALUES 
(1,'Singapore',' - ','2021-10-20','12:30','2021-10-28','22:10','Napoli','aerepoporto di singapore','hotel Singapore',55,4000),
(2,'Cuba Havana',' - ','21/12/2021','12:30','28/12/2021','22:10','Napoli','aerepoporto di havana','hotel gran havana',5,9000),
(3,'Miami',' - ','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel gran havana',5,9000),
(4,'Mauritius',' - ','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel gran havana',5,9000),
(5,'Napoli, Ischia e Caserta',' Questo tour vi permetter?? di conoscere un po??? in pi?? la Campania.. Napoli, Caserta e l???isola di Ischia sono solo alcune delle meraviglie di questa regione. Scoprite con noi quanto di pi?? bello questa regione pu?? offrirvi!','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(6,'Nord Italia Tour','Il tour si fa strada attraverso incantevoli localit?? come Milano e Torino; costeggia laghi meravigliosi come quelli di Como. Smetti di pensarci troppo: fai rotta verso uno dei percorsi pi?? suggestivi del vecchio continente.','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(7,' Venezia , Lago di Garda e Milano','Un tour speciale alla ricerca della tranquillit?? , della cultura e della bellezza paesaggistica dell???Italia','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(8,'Milano , Venezia e Firenze','Un tour fatto apposta per chi desidera essere cullato durante il viaggio : cene in ristoranti di classe , hotel lussuosi e viaggi in 1a classe','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(9,'Tour del cioccolato a Perugia','Oltre a famosi prodotti tipici , l??? Italia offre anche un buon cioccolato , e Perugia ?? il fulcro di questo buonissimo prodotto','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(10,'Sorrento e Amalfi con lezione di cucina','Tour alla scoperta dei sapori e cultura di Sorrento ed Amalfi con una piacevole lezione di cucina e visite guidate delle citt?? simbolo della Campania','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(11,'Tour del vino in Toscana','Il vino italiano ?? forse uno dei pi?? pregiati vini al mondo , se non il pi?? buono . Questo tour vi offre la possibilit?? di assaggiare i prodotti tipici della Toscana tra i quali proprio il Chianti ','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(12,'Cracovia',' - ','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(13,'Praga',' - ','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel ischia',5,9000),
(14,'Campania, Sorrento e Capri','Alle ore 8.30 partenza da Castellammare di Stabia / Sorrento. Arrivo a Capri, fermata a Grotta Bianca per fare un bagno, poi attraversare i famosi Faraglioni e proseguire fino a Nerano, riserva marina di Punta Campanella, con la possibilit?? di fare uno spuntino o un pranzo nella cambusa. Proseguire per Positano passando per le isole di Li Galli. Sbarco opzionale a Positano da spears per 2 ore e 30 minuti o andare su Amalfi. Godetevi il vostro tempo libero per circa 1 ora e 30 minuti. Il ritorno ?? previsto nel tardo pomeriggio attraverso Positano, lungo la costa per vedere le magnifiche spiagge e calette, villaggi e isole di pescatori','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino',' - ','hotel icapri',5,9000),
(15,'Puglia: Gargano ed Isole Tremiti','Partenza da Manfredonia in direzione Vieste per ammirare le baie pi?? belle della zona: Mattinatella, Baia di Zagare, Pugnochiuso. Cena tipica in barca ormeggiata nel porto di Vieste. Il secondo giorno, in direzione delle Isole Tremiti, vivrete un???esperienza unica in stretto contatto con il mare, circumnavigando le tre isole principali che formano l???arcipelago: San Domino, San Nicola e Capraia. Al terzo giorno ritorno a Manfredonia, arrivo alle ore 20.30.','21/12/2021','12:30','28/12/2021','20:30','Roma fiumicino','aerepoporto di havana','hotel gran havana',5,9000),
(16,'Lazio: dal Tevere ad Ostia Antica','Un viaggio affascinante alla scoperta del Tevere in modo nuovo e originale, apprezzando la flora e la fauna sorprendentemente ancora incontaminati. Procediamo visitando gli scavi di Ostia Antica, con la sua immensa zona archeologica perfettamente conservata. Alle 9.30 partenza da Roma, arrivo a Ostia alle 11.30; Visita guidata degli scavi archeologici di Ostia Antica e pranzo al sacco. Alle 16.00 torna a Roma in treno.','21/12/2021','12:30','28/12/2021','22:10','Roma fiumicino','aerepoporto di havana','hotel gran havana',5,9000);
UNLOCK TABLES;

LOCK TABLES `ordine` WRITE;
INSERT INTO `ordine` VALUES
 (1,'angela@maltour.com',false),
 (2,'teresa@maltour.com',false),
 (3,'lucia@maltour.com',false);
UNLOCK TABLES;

LOCK TABLES `componentiViaggio` WRITE;
INSERT INTO `componentiViaggio` VALUES
 (1,'Angela','Miranda','24/7/67'),
 (2,'Teresa','Vita','21/10/97'),
 (3,'Lucia','Longo','12/11/62');
UNLOCK TABLES;

LOCK TABLES `pagamento` WRITE;
INSERT INTO `pagamento` VALUES
 (1,'21413252464656','Angela Miranda','234','10/22'),
 (2,'23464573658795','Teresa Vita','567', '04/23'),
 (3,'32365272464565','Lucia Longo','789','01/24');
UNLOCK TABLES;

LOCK TABLES `ordine_offerta` WRITE;

UNLOCK TABLES;

LOCK TABLES `offerta_servizio` WRITE;
INSERT INTO `offerta_servizio` VALUES (5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,2),(12,2),(13,2),(1,3),(2,3),(3,3),(4,3),(14,4),(15,4),(16,4);
UNLOCK TABLES;