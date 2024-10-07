-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: techlingo
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `correct` bit(1) NOT NULL,
  `feedback_text` varchar(500) NOT NULL,
  `text` varchar(255) NOT NULL,
  `question_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3erw1a3t0r78st8ty27x6v3g1` (`question_id`),
  CONSTRAINT `FK3erw1a3t0r78st8ty27x6v3g1` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,_binary '','Python foi criado no final da década de 1980 por Guido van Rossum','Guido van Rossum',1),(2,_binary '\0','Python foi criado no final da década de 1980 por Guido van Rossum','Linus Torvalds',1),(3,_binary '\0','Python foi criado no final da década de 1980 por Guido van Rossum','James Gosling',1),(4,_binary '','Python é uma linguagem de programação de alto nível, conhecida por sua sintaxe simples e intuitiva, que facilita o aprendizado para iniciantes.','Linguagem de programação',2),(5,_binary '\0','Python é uma linguagem de programação de alto nível, conhecida por sua sintaxe simples e intuitiva, que facilita o aprendizado para iniciantes.','FrameWork Agil',2),(6,_binary '\0','Python é uma linguagem de programação de alto nível, conhecida por sua sintaxe simples e intuitiva, que facilita o aprendizado para iniciantes.','Uma ferramenta de Design',2),(7,_binary '\0','Python é amplamente utilizado em várias áreas, incluindo desenvolvimento web, análise de dados, inteligência artificial, aprendizado de máquina, automação de tarefas, e até no desenvolvimento de jogos.','Somente no desenvolvimento de aplicativos móveis.',3),(8,_binary '\0','Python é amplamente utilizado em várias áreas, incluindo desenvolvimento web, análise de dados, inteligência artificial, aprendizado de máquina, automação de tarefas, e até no desenvolvimento de jogos.','Apenas para criar sistemas operacionais.',3),(9,_binary '','Python é amplamente utilizado em várias áreas, incluindo desenvolvimento web, análise de dados, inteligência artificial, aprendizado de máquina, automação de tarefas, e até no desenvolvimento de jogos.','Desenvolvimento web, Análise de dados e IA.',3),(10,_binary '','Um algoritmo é uma lista de instruções ou um conjunto de passos que você segue para resolver um problema ou realizar uma tarefa','Um algoritmo é uma lista de instruções ou um conjunto de passos que você segue para resolver um problema ou realizar uma tarefa.',4),(11,_binary '\0','Um algoritmo é uma lista de instruções ou um conjunto de passos que você segue para resolver um problema ou realizar uma tarefa','Um algoritmo é uma receita de cozinha',4),(12,_binary '\0','Um algoritmo é uma lista de instruções ou um conjunto de passos que você segue para resolver um problema ou realizar uma tarefa','São dispositivos eletrônicos que processam dados e informações.',4),(13,_binary '\0','O comando \'se\' (ou if) é utilizado para tomar decisões no código. Ele avalia uma condição (como uma comparação ou estado de uma variável) e, se essa condição for verdadeira, executa o bloco de código associado. Caso contrário, o código é ignorado ou outro bloco de código pode ser executado.','Ele impede o programa de continuar a execução após a primeira linha.',5),(14,_binary '\0','O comando \'se\' (ou if) é utilizado para tomar decisões no código. Ele avalia uma condição (como uma comparação ou estado de uma variável) e, se essa condição for verdadeira, executa o bloco de código associado. Caso contrário, o código é ignorado ou outro bloco de código pode ser executado.','Ele executa uma ação repetidamente até que uma condição se torne falsa.',5),(15,_binary '','O comando \'se\' (ou if) é utilizado para tomar decisões no código. Ele avalia uma condição (como uma comparação ou estado de uma variável) e, se essa condição for verdadeira, executa o bloco de código associado. Caso contrário, o código é ignorado ou outro bloco de código pode ser executado.','Ele verifica se uma condição é verdadeira e, se for, executa uma ação.',5),(16,_binary '\0','O comando \'enquanto\' (ou while) instrui o computador a continuar realizando uma ação enquanto uma condição for verdadeira, como exemplificado pelo robô que continua colocando maçãs na cesta \'enquanto houver maçãs na mesa\'. Assim, o loop continua até que a condição pare de ser verdadeira, o que encerra a repetição.','Ele para o programa imediatamente ao encontrar uma condição falsa.',6),(17,_binary '','O comando \'enquanto\' (ou while) instrui o computador a continuar realizando uma ação enquanto uma condição for verdadeira, como exemplificado pelo robô que continua colocando maçãs na cesta \'enquanto houver maçãs na mesa\'. Assim, o loop continua até que a condição pare de ser verdadeira, o que encerra a repetição.','Ele executa uma ação repetidamente enquanto uma condição for verdadeira.',6),(18,_binary '\0','O comando \'enquanto\' (ou while) instrui o computador a continuar realizando uma ação enquanto uma condição for verdadeira, como exemplificado pelo robô que continua colocando maçãs na cesta \'enquanto houver maçãs na mesa\'. Assim, o loop continua até que a condição pare de ser verdadeira, o que encerra a repetição.','Ele executa uma ação apenas uma vez, independentemente da condição.',6),(19,_binary '','As variáveis podem ser alteradas durante a execução do programa','As variáveis podem ser alteradas durante a execução do programa.',7),(20,_binary '\0','As variáveis podem ser alteradas durante a execução do programa','As variáveis não podem conter textos.',7),(21,_binary '\0','As variáveis podem ser alteradas durante a execução do programa','As variáveis sempre armazenam valores inteiros.',7),(22,_binary '\0','O operador aritmético usado para calcular o resto de uma divisão é `%` ','*',8),(23,_binary '\0','O operador aritmético usado para calcular o resto de uma divisão é `%` ','/',8),(24,_binary '','O operador aritmético usado para calcular o resto de uma divisão é `%` ','%',8),(25,_binary '\0','O operador \'&&\' (E lógico) retorna verdadeiro apenas quando ambos os operandos são verdadeiros. Se qualquer um for falso, o resultado será falso. É utilizado para combinar condições que precisam ser verdadeiras ao mesmo tempo.','||',9),(26,_binary '','O operador \'&&\' (E lógico) retorna verdadeiro apenas quando ambos os operandos são verdadeiros. Se qualquer um for falso, o resultado será falso. É utilizado para combinar condições que precisam ser verdadeiras ao mesmo tempo.','&&',9),(27,_binary '\0','O operador \'&&\' (E lógico) retorna verdadeiro apenas quando ambos os operandos são verdadeiros. Se qualquer um for falso, o resultado será falso. É utilizado para combinar condições que precisam ser verdadeiras ao mesmo tempo.','!',9),(28,_binary '\0','A estrutura if/else é a principal usada para verificar condições e tomar decisões com base em diferentes cenários. O while e o for são usados para repetição, não para decisões.','while',10),(29,_binary '','A estrutura if/else é a principal usada para verificar condições e tomar decisões com base em diferentes cenários. O while e o for são usados para repetição, não para decisões.','if/else',10),(30,_binary '\0','A estrutura if/else é a principal usada para verificar condições e tomar decisões com base em diferentes cenários. O while e o for são usados para repetição, não para decisões.','for',10);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contents`
--

DROP TABLE IF EXISTS `contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contents` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image` longtext,
  `index` int NOT NULL,
  `text` longtext NOT NULL,
  `title` varchar(255) NOT NULL,
  `lesson_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKik5hu6owv9demykgetnrmjf4c` (`lesson_id`),
  CONSTRAINT `FKik5hu6owv9demykgetnrmjf4c` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contents`
--

LOCK TABLES `contents` WRITE;
/*!40000 ALTER TABLE `contents` DISABLE KEYS */;
INSERT INTO `contents` VALUES (1,NULL,1,'Python foi criado no final da década de 1980 por Guido van Rossum, com o objetivo de ser uma linguagem de programação de fácil leitura e escrita. A primeira versão foi lançada em 1991. Desde então, Python passou por várias atualizações, cada uma trazendo melhorias significativas em termos de recursos, performance e usabilidade. O nome “Python” foi inspirado no grupo de comédia britânico Monty Python, refletindo o desejo de Van Rossum de que a linguagem fosse divertida de usar.','História do Python',1),(2,NULL,2,'Python é uma linguagem de programação de alto nível, conhecida por sua sintaxe simples e intuitiva, que facilita o aprendizado para iniciantes. Suas características incluem tipagem dinâmica, o que significa que você não precisa declarar o tipo de uma variável antes de usá-la, e um extenso conjunto de bibliotecas que permitem realizar diversas tarefas sem precisar escrever muito código do zero. Isso torna Python uma excelente escolha para prototipagem rápida e desenvolvimento ágil.','Principais Vantagens da Linguagem Python',1),(3,NULL,3,'Python é amplamente utilizado em várias áreas, incluindo desenvolvimento web, análise de dados, inteligência artificial, aprendizado de máquina, automação de tarefas, e até no desenvolvimento de jogos. Frameworks como Django e Flask facilitam a criação de aplicativos web, enquanto bibliotecas como Pandas e NumPy são essenciais para manipulação e análise de dados.','Aplicações Diversificadas do Python no Mercado',1),(4,NULL,1,'Um algoritmo é uma lista de instruções ou um conjunto de passos que você segue para resolver um problema ou realizar uma tarefa. Pense em um algoritmo como uma receita de cozinha: você tem que seguir os passos em uma ordem específica para que o resultado seja como esperado. Na programação, usamos algoritmos para fazer o computador resolver problemas de forma organizada e eficiente. Um exemplo simples de algoritmo seria: \"1. Pegue um copo, 2. Abra a torneira, 3. Encha o copo de água.\" Se você seguir esses passos na ordem certa, vai conseguir um copo cheio de água. Assim funciona um algoritmo!','Entendendo Algoritmos',2),(5,NULL,2,'Na programação, muitas vezes precisamos que o computador faça algo só em certas condições. Para isso, usamos o comando \"se\" (ou if, em inglês). O comando \"se\" funciona como na vida real: por exemplo, \"se estiver chovendo, pegue um guarda-chuva\". O computador só executa uma ação se a condição que você definir for verdadeira. Vamos dizer que você está programando um jogo e quer que o personagem só pule se o jogador apertar a barra de espaço. Nesse caso, você diria para o computador: \"se a barra de espaço for pressionada, faça o personagem pular\". Assim, o computador só faz o que você mandar se a condição do \"se\" for atendida.','Tomando Decisões com \"Se\"',2),(6,NULL,3,'Na programação, muitas vezes precisamos repetir uma ação várias vezes. É aqui que entra o comando \"enquanto\" (ou while, em inglês). Esse comando diz ao computador para continuar fazendo algo \"enquanto\" uma certa condição for verdadeira. Imagine que você está programando um robô para colocar maçãs em uma cesta. Você diria: \"enquanto houver maçãs na mesa, continue colocando maçãs na cesta\". O robô vai continuar fazendo isso até que não reste mais nenhuma maçã. Da mesma forma, o computador continua repetindo as instruções até que a condição definida pare de ser verdadeira.','Repetindo Tarefas com \"Enquanto\"',2),(7,NULL,1,'As variáveis são elementos fundamentais em programação, pois permitem armazenar e manipular informações de forma eficaz. Elas funcionam como etiquetas que referenciam valores, possibilitando que você utilize e modifique esses dados ao longo do tempo. Por exemplo, ao declarar uma variável chamada idade, você pode armazenar e alterar a idade de um usuário conforme necessário. Esse recurso é especialmente útil em aplicativos interativos, onde os dados do usuário podem mudar frequentemente. O uso de variáveis torna o código mais legível e facilita a compreensão do que cada parte do programa faz, ajudando na manutenção e atualização do código ao longo do tempo.','A Importância das Variáveis',3),(8,NULL,2,'Os tipos de dados são importantes em programação, pois definem a natureza das informações que podem ser armazenadas em variáveis. Os tipos comuns incluem números inteiros (integer), números de ponto flutuante (float), strings (sequências de caracteres) e booleanos (verdadeiro/falso). Compreender esses tipos é fundamental para realizar operações corretas e evitar erros. Por exemplo, se você quiser armazenar o nome de um usuário, deverá usar uma variável do tipo string. A escolha correta do tipo de dado também pode impactar o desempenho do seu programa, uma vez que alguns tipos exigem mais recursos do que outros.','Tipos de Dados Comuns',3),(9,'https://linguagemc.com.br/wp-content/uploads/2012/03/OperadoresAritmeticos.jpg',1,'Os operadores aritméticos são usados para realizar cálculos matemáticos em programação. Eles permitem somar, subtrair, multiplicar, dividir e calcular o resto de divisões entre números. Esses operadores são fundamentais para a manipulação de dados numéricos em qualquer linguagem de programação.  Os principais operadores aritméticos são:','Operadores Aritméticos',4),(10,'https://miro.medium.com/v2/resize:fit:1400/1*7fUl_76Kr7GQmZb8_POErg.jpeg',2,'Os operadores lógicos são utilizados para realizar comparações e determinar a relação entre valores booleanos (verdadeiro ou falso). Esses operadores são amplamente usados em estruturas de controle, como condicionais e loops, para tomar decisões com base em condições específicas. <br> Os principais operadores lógicos são:','Operadores Lógicos',4),(11,'https://www.hashtagtreinamentos.com/wp-content/uploads/2021/07/Estruturas-Condicionais-no-Python-3.png',1,'As estruturas condicionais permitem que o programa tome decisões com base em determinadas condições. O mais comum é o if/else, que avalia uma condição e executa um bloco de código se a condição for verdadeira, e outro bloco se for falsa. Isso permite ao programa se adaptar e reagir a diferentes situações.','Estruturas Condicionais',5);
/*!40000 ALTER TABLE `contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Python','Aprenda Python para desenvolver rapidamente qualquer coisa, desde aplicações web até inteligência artificial.','https://www.tshirtgeek.com.br/wp-content/uploads/2021/03/com001.jpg');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollments`
--

DROP TABLE IF EXISTS `enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `current_lesson` int NOT NULL,
  `current_unit` int NOT NULL,
  `enrollment_date` datetime(6) NOT NULL,
  `course_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKho8mcicp4196ebpltdn9wl6co` (`course_id`),
  KEY `FK3hjx6rcnbmfw368sxigrpfpx0` (`user_id`),
  CONSTRAINT `FK3hjx6rcnbmfw368sxigrpfpx0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKho8mcicp4196ebpltdn9wl6co` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
INSERT INTO `enrollments` VALUES (1,4,0,'2024-10-02 15:51:25.979074',1,1),(2,0,0,'2024-10-04 18:46:38.149186',1,2);
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','create table courses','SQL','V1__create_table_courses.sql',-1052610113,'root','2024-10-01 19:02:02',83,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lessons`
--

DROP TABLE IF EXISTS `lessons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lessons` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `unit_id` bigint DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `points` double NOT NULL,
  `index` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_unit` (`unit_id`),
  CONSTRAINT `fk_unit` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lessons`
--

LOCK TABLES `lessons` WRITE;
/*!40000 ALTER TABLE `lessons` DISABLE KEYS */;
INSERT INTO `lessons` VALUES (1,1,'Python: Uma Introdução Simples e Versátil','Aqui iremos aprender um pouco mais sobre o que é o Python e como funciona.',100,1),(2,1,'Pensando como um Computador','Aprendendo fundamentos da Lógica de Programação',100,2),(3,1,'Variáveis e Tipos de Dados: Armazenando informações','Aqui iremos aprender a definir variáveis e os tipos de dados no python',100,3),(4,1,'Operadores aritméticos e lógicos: Realizando cálculos e comparações','Aqui iremos aprender os operadores aritméticos e lógicos ',100,4),(5,1,' Estruturas de controle: Tomando decisões e repetindo ações','Aqui iremos aprender a controlar o fluxo de execução de um programa.',100,5);
/*!40000 ALTER TABLE `lessons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `lesson_id` bigint DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `index` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lesson` (`lesson_id`),
  CONSTRAINT `fk_lesson` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'Quem foi o criador do Python?',1),(2,1,'O que é python?',2),(3,1,'Em quais áreas o Python é amplamente utilizado?',3),(4,2,'O que são algoritmos?',1),(5,2,'O que o comando \'se\' (ou if) faz na programação?',2),(6,2,'O que o comando \'enquanto\' (ou while) faz na programação?',3),(7,3,'Qual das seguintes afirmações é verdadeira sobre variáveis?',1),(8,4,'Qual operador aritmético é usado para calcular o resto de uma divisão?',1),(9,4,'Qual operador lógico retorna verdadeiro apenas se ambos os operandos forem verdadeiros?',2),(10,5,'Qual estrutura de controle é usada para tomar decisões com base em condições?',1);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `units` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_id` bigint DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `points` double NOT NULL,
  `index` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_course` (`course_id`),
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,1,'Unidade Básica de Python','Nesta unidade, vamos aprender os fundamentos da linguagem Python, como variáveis, tipos de dados e operadores',1000,1),(2,1,'Unidade de Python Intermediária','Aqui iremos ver conteudos como Listas, Tuplas, Manipulação de Strings etc...',1000,2);
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` datetime(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `last_access_date` datetime(6) DEFAULT NULL,
  `lives` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `score` decimal(38,2) NOT NULL,
  `user_role` enum('ADMIN','USER') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-10-01 16:12:57.839502','renansk18@outlook.com','2024-10-06 21:25:50.438144',5,'Renan Pollo','renan123',4900.00,'USER'),(2,'2024-10-04 18:44:36.512058','gabriel@gmail.com','2024-10-05 21:33:24.737260',4,'Gabriel','gabriel123',0.00,'USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-06 21:42:21
